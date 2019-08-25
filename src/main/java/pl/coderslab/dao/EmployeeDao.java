package pl.coderslab.dao;

import pl.coderslab.datamodel.Employee;
import pl.coderslab.utils.DbUtil;
import pl.coderslab.utils.DeleteByIdCommon;

import java.sql.*;
import java.util.ArrayList;

public class EmployeeDao {

    private static final String CREATE_QUERY = "insert into employees (name, surname, address, phone_number, note, wage_hourly) values (?, ?, ?, ?, ?, ?);";
    private static final String READ_BY_ID_QUERY = "select * from employees where id = ?;";
    private static final String READ_ALL_QUERY = "select * from employees;";
    private static final String UPDATE_QUERY = "update employees set name = ?, surname = ?, address = ?, phone_number = ?, note = ?, wage_hourly = ? where id = ?;";
    private static final String DELETE_QUERY = "delete from employees where id = ?;";
    private static final String GET_WAGE_QUERY = "select wage_hourly from employees where id = ?;";
    //CREATE

    public static Employee create(Employee employee) {

        ResultSet rS = null;
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(CREATE_QUERY, Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, employee.getName());
            statement.setString(2, employee.getSurname());
            statement.setString(3, employee.getAddress());
            statement.setInt(4, employee.getPhoneNo());
            statement.setString(5, employee.getNote());
            statement.setInt(6, employee.getWageHourly());

            statement.executeUpdate();

            rS = statement.getGeneratedKeys();

            while (rS.next()) {

                employee.setId(rS.getInt(1));

            }

            return employee;

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

    //READ

    public static Employee readById(int id) {

        ResultSet rS = null;
        ArrayList<Employee> employees = new ArrayList<Employee>();

        try (Connection connection = DbUtil.getConnection();
        PreparedStatement statement = connection.prepareStatement(READ_BY_ID_QUERY)) {

            statement.setInt(1, id);
            rS = statement.executeQuery();

            Employee employee = new Employee();

            while (rS.next()) {

                employee.setId(rS.getInt(1));
                employee.setName(rS.getString(2));
                employee.setSurname(rS.getString(3));
                employee.setAddress(rS.getString(4));
                employee.setPhoneNo(rS.getInt(5));
                employee.setNote(rS.getString(6));
                employee.setWageHourly(rS.getInt(7));
            }

            return employee;


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

    public static int readWageById(int id) {

        ResultSet rS = null;

        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_WAGE_QUERY)) {

            statement.setInt(1, id);
            rS = statement.executeQuery();
            int wage = 0;

            while (rS.next()) {
                wage = rS.getInt(1);
            }
            return wage;

            //return rS.getInt(1);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("błąd");
            return 0;
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

    public static ArrayList<Employee> readAll() {

        ResultSet rS = null;
        ArrayList<Employee> employees = new ArrayList<Employee>();

        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(READ_ALL_QUERY);) {

            rS = statement.executeQuery();

            while (rS.next()) {

                Employee employee = new Employee();

                employee.setId(rS.getInt(1));
                employee.setName(rS.getString(2));
                employee.setSurname(rS.getString(3));
                employee.setAddress(rS.getString(4));
                employee.setPhoneNo(rS.getInt(5));
                employee.setNote(rS.getString(6));
                employee.setWageHourly(rS.getInt(7));

                employees.add(employee);
            }

            return employees;

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

    //UPDATE

    public static boolean update(Employee employee) {

        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {

            statement.setString(1 ,employee.getName());
            statement.setString(2, employee.getSurname());
            statement.setString(3, employee.getAddress());
            statement.setInt(4, employee.getPhoneNo());
            statement.setString(5, employee.getNote());
            statement.setInt(6, employee.getWageHourly());
            statement.setInt(7, employee.getId());

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

    //DELETE

    public static boolean delete(int id) {

        return DeleteByIdCommon.deleteByIdCommon(id, DELETE_QUERY);
    }

}
