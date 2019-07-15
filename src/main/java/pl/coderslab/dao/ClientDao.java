package pl.coderslab.dao;

import pl.coderslab.datamodel.Client;
import pl.coderslab.utils.DbUtil;
import pl.coderslab.utils.DeleteByIdCommon;

import java.sql.*;
import java.util.ArrayList;

public class ClientDao {

    private static final String CREATE_QUERY = "insert into clients (name, surname, date_of_birth, mail) VALUES (?, ?, ?, ?);";
    private static final String SEARCH_BY_ID_QUERY = "select * from clients where id = ?;";
    private static final String SEARCH_ALL_QUERY = "select * from clients;";
    private static final String UPDATE_QUERY = "update clients set name = ?, surname = ?, date_of_birth = ?, mail = ? where id = ?;";
    private static final String DELETE_QUERY = "delete from clients where id = ?;";

    //CREATE

    public Client create(Client client) {

        ResultSet rS = null;

        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(CREATE_QUERY, Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, client.getName());
            statement.setString(2, client.getSurname());
            statement.setTimestamp(3, client.getDateOfBirth());
            statement.setString(4, client.getMail());

            statement.executeUpdate();

            rS = statement.getGeneratedKeys();

            while (rS.next()) {

                client.setId(rS.getInt(1));
            }

            return client;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rS.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }


    //READ

    public static Client readById(int id) {

        ResultSet rS = null;

        try(Connection connection = DbUtil.getConnection();
        PreparedStatement statement = connection.prepareStatement(SEARCH_BY_ID_QUERY)) {

            statement.setInt(1, id);
            rS = statement.executeQuery();

            Client client = new Client();
            while (rS.next()) {
                client.setId(id);
                client.setName(rS.getString(2));
                client.setSurname(rS.getString(3));
                client.setDateOfBirth(rS.getTimestamp(4));
                client.setMail(rS.getString(5));
            }

            return client;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rS.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public ArrayList<Client> readAll() {

        ResultSet rS = null;
        ArrayList<Client> clients = new ArrayList<Client>();

        try (Connection connection = DbUtil.getConnection();
        Statement statement = connection.createStatement()) {

            rS = statement.executeQuery(SEARCH_ALL_QUERY);

            while (rS.next()) {
                Client client = new Client();
                client.setId(rS.getInt(1));
                client.setName(rS.getString(2));
                client.setSurname(rS.getString(3));
                client.setDateOfBirth(rS.getTimestamp(4));
                client.setMail(rS.getString(5));
                clients.add(client);
            }
            return  clients;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rS.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return clients;
    }

    //UPDATE

    public static boolean update(Client client) {

        try (Connection connection = DbUtil.getConnection();
        PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {

            statement.setString(1 ,client.getName());
            statement.setString(2, client.getSurname());
            statement.setTimestamp(3, client.getDateOfBirth());
            statement.setString(4, client.getMail());
            statement.setInt(5, client.getId());

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

        DeleteByIdCommon deleteByIdCommon = new DeleteByIdCommon();

        return deleteByIdCommon.deleteByIdCommon(id, DELETE_QUERY);
    }

}
