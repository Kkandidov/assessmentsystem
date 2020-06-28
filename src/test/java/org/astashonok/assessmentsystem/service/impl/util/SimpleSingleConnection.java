package org.astashonok.assessmentsystem.service.impl.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SimpleSingleConnection {
    private String URL;
    private String USER_NAME;
    private String PASSWORD;

    private SimpleSingleConnection(){
        Properties properties = new Properties();
        InputStream is = SimpleSingleConnection.class.getResourceAsStream("/testdatabase.properties");
        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        URL = (properties.getProperty("url"));
        USER_NAME = properties.getProperty("username");
        PASSWORD = properties.getProperty("password");
        try {
            Class.forName((properties.getProperty("driver")));
        } catch (ClassNotFoundException e) {
            System.out.println("Driver isn't found! ");
            e.printStackTrace();
        }
    }

    private static class SimpleSingleConnectionHandler{
        private final static SimpleSingleConnection instance = new SimpleSingleConnection();
    }

    public static SimpleSingleConnection getInstance(){
        return SimpleSingleConnectionHandler.instance;
    }

    public Connection getConnection() throws SQLException {
        System.out.println("Connecting...");
        Connection connection;
        connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        System.out.println("Connection is successful!");
        return connection;
    }
}
