package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJDBC {
    private static String url = "jdbc:mysql://localhost:3306/product_manager";
    private static String user = "root";
    private static String password = "mylove99";
    public static Connection getConnection(){
        Connection connection=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url,
                    user,
                    password
            );
        } catch (ClassNotFoundException e) {
            System.out.println("No driver");
        } catch (SQLException throwables) {
            System.out.println("Can't connect");
        }
        System.out.println("Connect");

        return connection;
    }
}
