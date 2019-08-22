package pl.coderslab.dao;

import pl.coderslab.datamodel.reports.ReportBasic;
import pl.coderslab.utils.DbUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ReportBaiscDao {

    private static final String READ_QUERY = "select ro.id, ro.repair_status, ro.repair_start_date_planned, ro.repair_start_date, v.brand, v.model, v.production_year," +
            " v.registration_no, v.next_inspection_date, ro.defect_description, ro.repair_description, ro.repair_cost, ro.repair_hours, ro.repair_parts_cost, e.name," +
            " e.surname, e.wage_hourly, c.surname, c.name from repair_order ro left join vehicle v on ro.repair_vehical = v.id left join employees e on" +
            " ro.assigned_repairman = e.id left join clients c on v.client_id = c.id;";

    public ArrayList<ReportBasic> readAll()  {

        ResultSet rS = null;

        try(Connection connection = DbUtil.getConnection(); Statement statement = connection.createStatement()) {
            rS = statement.executeQuery(READ_QUERY);
            ArrayList<ReportBasic> report = new ArrayList<>();
            while (rS.next()) {
                ReportBasic reportBasic = new ReportBasic();
                reportBasic.setId(rS.getInt(1));
                reportBasic.setRepairStatus(rS.getString(2));
                reportBasic.setRepairStartDatePlanned(rS.getTimestamp(3));
                reportBasic.setRepairStartDate(rS.getTimestamp(4));
                reportBasic.setBrand(rS.getString(5));
                reportBasic.setModel(rS.getString(6));
                reportBasic.setProductionYear(rS.getInt(7));
                reportBasic.setRegistrationNo(rS.getString(8));
                reportBasic.setNextInspection(rS.getDate(9));
                reportBasic.setDefectDescription(rS.getString(10));
                reportBasic.setRepairDescription(rS.getString(11));
                reportBasic.setRepairCost(rS.getInt(12));
                reportBasic.setRepairHours(rS.getInt(13));
                reportBasic.setPartsCost(rS.getInt(14));
                reportBasic.setSurnameRepairman(rS.getString(15));
                reportBasic.setNameRepairman(rS.getString(16));
                reportBasic.setWageHourly(rS.getInt(17));
                reportBasic.setClientSurname(rS.getString(18));
                reportBasic.setClientName(rS.getString(19));
                report.add(reportBasic);
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
