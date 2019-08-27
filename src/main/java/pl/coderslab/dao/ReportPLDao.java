package pl.coderslab.dao;

import pl.coderslab.datamodel.reports.ReportProfitLoss;
import pl.coderslab.datamodel.reports.ReportSalary;
import pl.coderslab.utils.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class ReportPLDao {

    private static final String READ_QUERY = "select sum(repair_cost) as gross_income, sum(0.5*repair_parts_cost) as parts_net," +
            " sum(0.6*repair_hours*repair_wage_hourly_cost) as wages, sum(repair_cost) -" +
            " sum(0.6*repair_hours*repair_wage_hourly_cost) - sum(0.5*repair_parts_cost)  as net_income from repair_order" +
            "  where repair_start_date between ? and ?;";


    public ReportProfitLoss readAll(Timestamp start, Timestamp end)  {

        ResultSet rS = null;

        try(Connection connection = DbUtil.getConnection(); PreparedStatement statement = connection.prepareStatement(READ_QUERY)) {

            statement.setTimestamp(1, start);
            statement.setTimestamp(2, end);
            rS = statement.executeQuery();
            ReportProfitLoss profitLoss = new ReportProfitLoss();
            while (rS.next()) {
                profitLoss.setIncomeGross(rS.getDouble(1));
                profitLoss.setPartsCostNet(rS.getDouble(2));
                profitLoss.setWagesNet(rS.getDouble(3));
                profitLoss.setIncomeNet(rS.getDouble(4));
            }
            return profitLoss;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (rS != null) {
                try {
                    rS.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
