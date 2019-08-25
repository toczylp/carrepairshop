package pl.coderslab.dao;

import java.sql.*;
import java.util.ArrayList;
import pl.coderslab.datamodel.Order;
import pl.coderslab.utils.DbUtil;
import pl.coderslab.utils.DeleteByIdCommon;

public class OrderDao {

    private static final String CREATE_QUERY_CAR_INBOUND = "insert into repair_order " +
            "(repair_start_date_planned, assigned_repairman, defect_description, repair_status, " +
            "repair_vehical, repair_wage_hourly_cost) " +
            "VALUES (?, ?, ?, ?, ?, ?);";

    private static final String CREATE_QUERY = "insert into repair_order " +
            "(repair_start_date_planned, repair_start_date, assigned_repairman, defect_description, repair_description, repair_status, " +
            "repair_vehical, repair_cost, repair_parts_cost, repair_wage_hourly_cost, repair_hours) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String READ_BY_ID_QUERY = "select * from repair_order where id = ?;";
    private static final String READ_ALL_QUERY = "select * from repair_order;";
    private static final String READ_ALL_ACTIVE_QUERY = "select * from repair_order where repair_status = 'in repair';";
    private static final String UPDATE_QUERY = "update repair_order set repair_start_date = ?, repair_description = ?, repair_cost = ?, repair_parts_cost = ?," +
            " repair_wage_hourly_cost = ?, repair_hours =? where id = ?;";
    private static final String UPDATE_QUERY_ORDER_STATUS = "update repair_order set repair_status = ? where id = ?;";
    private static final String DELETE_QUERY = "delete from repair_order where id = ?;";


    // CREATE : car inbound

    public static Order carInbound(Order order) {

        ResultSet rS = null;

        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(CREATE_QUERY_CAR_INBOUND, Statement.RETURN_GENERATED_KEYS)) {

            statementDataInput(order, statement);
            statement.executeUpdate();

            rS = statement.getGeneratedKeys();

            while (rS.next()) {

                order.setId(rS.getInt(1));
            }

            return order;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rS != null) {
                    rS.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    // Standard create DAO method :

   /* public static Order create(Order order) {

        ResultSet rS = null;

        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(CREATE_QUERY, Statement.RETURN_GENERATED_KEYS)) {

            statementDataInput(order, statement);
            statement.executeUpdate();

            rS = statement.getGeneratedKeys();

            while (rS.next()) {

                order.setId(rS.getInt(1));
            }

            return order;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rS != null) {
                    rS.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }*/

    private static void statementDataInput(Order order, PreparedStatement statement) throws SQLException {
        statement.setTimestamp(1, order.getRepairStartDatePlanned());
        statement.setInt(2, order.getAssignedRepairmanId());
        statement.setString(3, order.getDefectDescription());
        statement.setString(4, order.getStatus());
        statement.setInt(5, order.getVehicalId());
        statement.setInt(6, order.getWageHourly());
    }

    //READ

    public static Order readById(int id) {

        ResultSet rS = null;

        try(Connection connection = DbUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(READ_BY_ID_QUERY)) {

            statement.setInt(1, id);
            rS = statement.executeQuery();

            Order order = new Order();
            while (rS.next()) {
                orderFieldsInput(id, rS, order);
            }

            return order;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rS != null) {
                    rS.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private static void orderFieldsInput(int id, ResultSet rS, Order order) throws SQLException {
        order.setId(id);
        order.setRepairStartDatePlanned(rS.getTimestamp(2));
        order.setRepairStartDate(rS.getTimestamp(3));
        order.setAssignedRepairmanId(rS.getInt(4));
        order.setDefectDescription(rS.getString(5));
        order.setRepairDescription(rS.getString(6));
        order.setStatus(rS.getString(7));
        order.setVehicalId(rS.getInt(8));
        order.setPartsCost(rS.getInt(10));
        order.setWageHourly(rS.getInt(11));
        order.setRepairHours(rS.getInt(12));
        order.setRepairCost();
    }

    private static void orderFieldsInput(ResultSet rS, Order order) throws SQLException {
        order.setId(rS.getInt(1));
        order.setRepairStartDatePlanned(rS.getTimestamp(2));
        order.setRepairStartDate(rS.getTimestamp(3));
        order.setAssignedRepairmanId(rS.getInt(4));
        order.setDefectDescription(rS.getString(5));
        order.setRepairDescription(rS.getString(6));
        order.setStatus(rS.getString(7));
        order.setVehicalId(rS.getInt(8));
        order.setPartsCost(rS.getInt(10));
        order.setWageHourly(rS.getInt(11));
        order.setRepairHours(rS.getInt(12));
        order.setRepairCost();
    }

    public static ArrayList<Order> readAllActive() {

        ResultSet rS = null;
        ArrayList<Order> orders = new ArrayList<Order>();

        try(Connection connection = DbUtil.getConnection();
            Statement statement = connection.createStatement()) {

            rS = statement.executeQuery(READ_ALL_ACTIVE_QUERY);

            while (rS.next()) {

                Order order = new Order();
                orderFieldsInput(rS, order);

                orders.add(order);
            }

            return orders;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rS != null) {
                    rS.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static ArrayList<Order> readAll(int id) {

        ResultSet rS = null;
        ArrayList<Order> orders = new ArrayList<Order>();

        try(Connection connection = DbUtil.getConnection();
            Statement statement = connection.createStatement()) {

            rS = statement.executeQuery(READ_ALL_QUERY);

            while (rS.next()) {

                Order order = new Order();
                orderFieldsInput(id, rS, order);

                orders.add(order);
            }

            return orders;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rS != null) {
                    rS.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    //UPDATE

    public static boolean update(Order order) {


        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {


            statement.setTimestamp(1, order.getRepairStartDate());
            statement.setString(2, order.getRepairDescription());
            statement.setInt(3, order.getRepairCost());
            statement.setInt(4, order.getPartsCost());
            statement.setInt(5, order.getWageHourly());
            statement.setInt(6, order.getRepairHours());
            statement.setInt(7, order.getId());
            int answer = statement.executeUpdate();

            if (answer == 1) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static boolean updateStatus(Order order) {


        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {


            statement.setString(1, order.getStatus());
            statement.setInt(2, order.getId());

            int answer = statement.executeUpdate();

            if (answer == 1) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }


    //DELETE

    public static boolean delete(int id) {

        return DeleteByIdCommon.deleteByIdCommon(id, DELETE_QUERY);
    }

}
