package pl.coderslab.dao;

import pl.coderslab.datamodel.Vehicle;
import pl.coderslab.utils.DbUtil;
import pl.coderslab.utils.DeleteByIdCommon;

import java.sql.*;
import java.util.ArrayList;
import java.util.function.DoubleBinaryOperator;

public class VehicleDao {

    private static final String CREATE_QUERY = "insert into vehicle (model, brand, production_year, registration_no, next_inspection_date, client_id) VALUES (?, ?, ?, ?, ? , ?);";
    private static final String SEARCH_BY_ID_QUERY = "select * from vehicle where id = ?;";
    private static final String SEARCH_ALL_QUERY = "select * from vehicle;";
    private static final String UPDATE_QUERY = "update vehicle set model = ?, brand = ?, production_year = ?, registration_no = ?, next_inspection_date = ?, client_id = ? where id = ?;";
    private static final String DELETE_QUERY = "delete from vehicle where id = ?;";

    public static Vehicle create(Vehicle vehicle) {

        //CREATE

        ResultSet rS = null;

        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(CREATE_QUERY, Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, vehicle.getModel());
            statement.setString(2, vehicle.getBrand());
            statement.setInt(3, vehicle.getProductionYear());
            statement.setString(4, vehicle.getRegistrationNo());
            statement.setTimestamp(5, vehicle.getNextInspectionDate());
            statement.setInt(6, vehicle.getClientId());
            statement.executeUpdate();

            rS = statement.getGeneratedKeys();

            while (rS.next()) {
                vehicle.setVehicalId(rS.getInt(1));
            }

            return vehicle;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                rS.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //READ

    public static Vehicle readById(int id) {

        ResultSet rS = null;

        try (Connection connection = DbUtil.getConnection();
        PreparedStatement statement = connection.prepareStatement(SEARCH_BY_ID_QUERY)) {

            statement.setInt(1, id);

            rS = statement.executeQuery();
            Vehicle vehicle = new Vehicle();

            while (rS.next()) {

                vehicle.setVehicalId(id);
                vehicle.setModel(rS.getString(1));
                vehicle.setBrand(rS.getString(2));
                vehicle.setProductionYear(rS.getInt(3));
                vehicle.setRegistrationNo(rS.getString(4));
                vehicle.setNextInspectionDate(rS.getTimestamp(5));
                vehicle.setClientId(rS.getInt(6));
            }
            return vehicle;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                rS.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static ArrayList<Vehicle> readAll() {

        ResultSet rS = null;

        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle> ();

        try (Connection connection = DbUtil.getConnection();
        Statement statement = connection.createStatement()){

            rS = statement.executeQuery(SEARCH_ALL_QUERY);

            while (rS.next()) {

                Vehicle vehicle = new Vehicle();

                vehicle.setVehicalId(rS.getInt(1));
                vehicle.setModel(rS.getString(2));
                vehicle.setBrand(rS.getString(3));
                vehicle.setProductionYear(rS.getInt(4));
                vehicle.setRegistrationNo(rS.getString(5));
                vehicle.setNextInspectionDate(rS.getTimestamp(6));
                vehicle.setClientId(rS.getInt(7));

                vehicles.add(vehicle);
            }
            return vehicles;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                rS.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean update(Vehicle vehicle) {

        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {

            statement.setString(1, vehicle.getModel());
            statement.setString(2, vehicle.getBrand());
            statement.setInt(3, vehicle.getProductionYear());
            statement.setString(4, vehicle.getRegistrationNo());
            statement.setTimestamp(5, vehicle.getNextInspectionDate());
            statement.setInt(6, vehicle.getClientId());
            statement.setInt(7, vehicle.getVehicalId());

            int answer = statement.executeUpdate();

            if(answer == 1) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean delete(int id) {

        DeleteByIdCommon deleteByIdCommon = new DeleteByIdCommon();

        return deleteByIdCommon.deleteByIdCommon(id, DELETE_QUERY);
    }
}
