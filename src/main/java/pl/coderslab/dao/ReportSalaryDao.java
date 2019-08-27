package pl.coderslab.dao;

import pl.coderslab.datamodel.reports.ReportBasic;
import pl.coderslab.datamodel.reports.ReportSalary;
import pl.coderslab.utils.DbUtil;

import java.sql.*;
import java.util.ArrayList;

public class ReportSalaryDao {
    private static final String READ_QUERY = "select e.surname, e.name, assigned_repairman, sum(repair_hours*wage_hourly) from repair_order" +
            " join employees e on repair_order.assigned_repairman = e.id " +
            "where repair_start_date between ?  and ? group by assigned_repairman;";


    public ArrayList<ReportSalary> readAll(Timestamp start, Timestamp end)  {

        ResultSet rS = null;

        try(Connection connection = DbUtil.getConnection(); PreparedStatement statement = connection.prepareStatement(READ_QUERY)) {

            statement.setTimestamp(1, start);
            statement.setTimestamp(2, end);
            rS = statement.executeQuery();
            ArrayList<ReportSalary> report = new ArrayList<>();
            while (rS.next()) {
                ReportSalary reportSalary = new ReportSalary();
                reportSalary.setName(rS.getString(1));
                reportSalary.setSurname(rS.getString(2));
                reportSalary.setSalary(rS.getInt(4));
                report.add(reportSalary);
            }
            return report;

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
