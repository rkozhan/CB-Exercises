package main.java.connection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DatabaseQuery {
    public static void main(String[] args) {
        // db settings must be loaded from the properties file
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
                Connection connection = DriverManager.getConnection(properties.getProperty("db.url"),
                        properties.getProperty("db.user"), properties.getProperty("db.password"));
                /*
                // create SQL statement
                Statement statement = connection.createStatement();

                String query = "SELECT * FROM passenger;";
                // execute query
                ResultSet resultSet = statement.executeQuery(query);

                // print result
                while (resultSet.next()) {
                    int id = resultSet.getInt("P_Nr");
                    String name = resultSet.getString("P_FNAME");

                    System.out.println("ID: " + id + ", Name: " + name);
                }

                 */

            /*
                write a method which takes a parameter for the following statement.
                Execute it with a prepared statement.
                SELECT guest_id from guests where name=parameter
             */
                findAndPrintPersonIDByName(connection, "Jane");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void findAndPrintPersonIDByName(Connection connection, String name) {
        String findByNameQueryString = "SELECT id from persons where P_FNAME=?;";

        try {
            PreparedStatement findByName = connection.prepareStatement(findByNameQueryString);
            // set the parameter
            findByName.setString(1, name);
            ResultSet resultSet = findByName.executeQuery();

            while (resultSet.next()) {
                System.out.println(name + " has the ID: " + resultSet.getInt("P_Nr"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
