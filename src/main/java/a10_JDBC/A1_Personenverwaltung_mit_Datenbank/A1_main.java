package main.java.a10_JDBC.A1_Personenverwaltung_mit_Datenbank;
import main.java.a5_OOP1.A4_Personenvervaltung_V2.Person;
import main.java.connection.DatabaseQuery;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.time.LocalDate;
import java.util.Properties;

public class A1_main {
    public static void main(String[] args) throws SQLException {
        PersonnelManagement cb = new PersonnelManagement("PV CODERS.BAY");

        Connection connection = connectToDataBase(cb);

        cb.addPersonsFromDB(); // from database to list

        cb.createPerson("", "Doe");
        cb.createPerson("John", "");
        cb.createPerson("John", "Doe", LocalDate.of(1900, 1, 21), null, 1234, "Berlin", "Rotestraße", 75);
        cb.createPerson("John", "Doe", LocalDate.of(2900, 1, 21), Person.Gender.MALE, 1234, "Berlin", "Rotestraße", 75);
        cb.createPerson("John", "Doe", LocalDate.of(1900, 1, 21), Person.Gender.MALE, 12345, "Berlin", "Rotestraße", 75);
        cb.createPerson("John", "Doe", LocalDate.of(1900, 1, 21), Person.Gender.MALE, 1234, "Berlin", "Rotestraße", 75);
        cb.createPerson("Jane", "Doe", LocalDate.of(1910, 1, 21), Person.Gender.FEMALE);
        cb.createPerson("Jakob", "Doe");
        cb.deletePerson("Jakob", "Doe");

        close(connection);
    }

    public static Connection connectToDataBase(PersonnelManagement pManagement) {
        Connection connection;
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
                connection = DriverManager.getConnection(properties.getProperty("db.url"),
                        properties.getProperty("db.user"), properties.getProperty("db.password"));
                if (!connection.isClosed()) System.out.println("...Connection is opened");

                pManagement.setConnection(connection);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public static void close(Connection connection) throws SQLException {
        connection.close();
        if(connection.isClosed()) System.out.println("...Connection is closed");
    }
}

/*
Aufgabe: Personenverwaltung mit Datenbank
Erweitere deine Personenverwaltung um eine Datenbank in der du die Personen abspeichern kannst.
https://wiki.streampy.at/index.php?title=Java_-_OOP_1#Aufgabe:_Personenverwaltung
 */