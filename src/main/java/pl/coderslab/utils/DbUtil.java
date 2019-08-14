package pl.coderslab.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {

    private static final String user = "root";
    private static final String pwd = "coderslab";
    private static final String url = "jdbc:mysql://localhost:3306/carrepairshop?useSSL=false&characterEncoding=utf8&useUnicode=true";

    public static Connection getConnection() throws SQLException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return DriverManager.getConnection(url, user, pwd);

    }
}
