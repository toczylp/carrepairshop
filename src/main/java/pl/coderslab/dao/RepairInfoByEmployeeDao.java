package pl.coderslab.dao;

import pl.coderslab.datamodel.reports.RepairInfoByEmployee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static pl.coderslab.utils.DbUtil.getConnection;

public class RepairInfoByEmployeeDao {

    private static final String READ_QUERY = "select ro.id, ro.repair_start_date, ro.defect_description, ro.repair_description, ro.repair_status, v.model, v.brand, v.registration_no," +
            " ro.repair_hours, ro.repair_cost, e.name, e.surname from repair_order ro join vehicle v on ro.repair_vehical = v.id join " +
            "employees e on ro.assigned_repairman = e.id where ro.assigned_repairman = ?;";

    // Only for data read from DB

    public ArrayList<RepairInfoByEmployee> readById(int id) {
        ArrayList<RepairInfoByEmployee> list = new ArrayList<>();

        ResultSet rS = null;

        try (Connection connection =  getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(READ_QUERY)) {

            preparedStatement.setInt(1, id);
            rS = preparedStatement.executeQuery();

            while (rS.next()) {
                RepairInfoByEmployee repairInfoByEmployee = new RepairInfoByEmployee();
                repairInfoByEmployee.setId(rS.getInt(1));
                repairInfoByEmployee.setRepairStartDate(rS.getTimestamp(2));
                repairInfoByEmployee.setDefectDescription(rS.getString(3));
                repairInfoByEmployee.setRepairDescription(rS.getString(4));
                repairInfoByEmployee.setStatus(rS.getString(5));
                repairInfoByEmployee.setModel(rS.getString(6));
                repairInfoByEmployee.setBrand(rS.getString(7));
                repairInfoByEmployee.setRegistrationNo(rS.getString(8));
                repairInfoByEmployee.setRepairHours(rS.getInt(9));
                repairInfoByEmployee.setRepairCost(rS.getInt(10));
                repairInfoByEmployee.setNameRepairman(rS.getString(11));
                repairInfoByEmployee.setSurnameRepairman(rS.getString(12));
                list.add(repairInfoByEmployee);
            }

            return list;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (rS != null) {
                    rS.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
