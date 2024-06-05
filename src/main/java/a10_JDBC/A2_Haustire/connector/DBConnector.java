package main.java.a10_JDBC.A2_Haustire.connector;

import main.java.connection.DatabaseQuery;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Arrays;
import java.util.Properties;
public class DBConnector {
    private static DBConnector connector = null;
    private static Connection conn;
    private DBConnector() {
        conn = connectToDataBase();
        //createTables();
    };

    public static synchronized DBConnector getInstance() {
        if (connector == null) {
            connector = new DBConnector();
        }
        return connector;
    }

    static Connection connectToDataBase() {
        Connection newConnection;
        //db settings must be loaded from the properties file
        try (InputStream configFileInput = DatabaseQuery.class.getClassLoader()
                .getResourceAsStream("main/resources/connection.properties")) {
            if (configFileInput == null) {
                throw new RuntimeException("Properties file not found!");
            }

            Properties properties = new Properties();
            // load property file
            properties.load(configFileInput);
            try {
                // establish connection
                newConnection = DriverManager.getConnection(properties.getProperty("db.url"),
                        properties.getProperty("db.user"), properties.getProperty("db.password"));
                if (!newConnection.isClosed()) System.out.println("...Connection is opened");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return newConnection;
    }

    public Connection getConnection() {
        return conn;
    }

    public static void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
                if (conn.isClosed()) {
                    System.out.println("...Connection is closed");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    static void createTables() {
        try (Statement st = conn.createStatement()) {
            for (String query : Arrays.asList(
                    "CREATE TABLE IF NOT EXISTS households (" +
                            "household_id INT AUTO_INCREMENT PRIMARY KEY, " +
                            "name VARCHAR(50) NOT NULL)",

                    "CREATE TABLE IF NOT EXISTS h_persons (" +
                            "person_id INT AUTO_INCREMENT PRIMARY KEY, " +
                            "first_name VARCHAR(50) NOT NULL, " +
                            "household_id INT, " +
                            "FOREIGN KEY (household_id) REFERENCES households(household_id) ON DELETE CASCADE)",

                    "CREATE TABLE IF NOT EXISTS pets (" +
                            "pet_id INT AUTO_INCREMENT PRIMARY KEY, " +
                            "name VARCHAR(50) NOT NULL, " +
                            "person_id INT, " +
                            "FOREIGN KEY (person_id) REFERENCES h_persons(person_id) ON DELETE CASCADE)"
            )) {
                st.execute(query);
            }
        }
        catch (SQLException e) {
            System.out.println("Some sql error: " + e.getMessage());
        }
    }
}

