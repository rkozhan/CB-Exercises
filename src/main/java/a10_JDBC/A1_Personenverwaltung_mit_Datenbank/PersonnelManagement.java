package main.java.a10_JDBC.A1_Personenverwaltung_mit_Datenbank;
import main.java.a5_OOP1.A4_Personenvervaltung_V2.Person;
import java.time.LocalDate;
import java.sql.*;

public class PersonnelManagement extends main.java.a5_OOP1.A4_Personenvervaltung_V2.PersonnelManagement {
    private Connection connection;
    public PersonnelManagement(String pvName) {
        super(pvName);
    }
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public void addPersonsFromDB () {
        String query = "SELECT * FROM persons;";
        try (PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String name = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                Date date = rs.getDate("date_of_birth");
                LocalDate dateOfBirth = date != null ? date.toLocalDate() : null;
                String gender = rs.getString("gender");
                int postalCode = rs.getInt("postal_code");
                String city = rs.getString("city");
                String street = rs.getString("street");
                int houseNumber = rs.getInt("house_number");

                if (street != null && !street.isEmpty() && city != null && !city.isEmpty()) {
                    createPerson(name, lastName, dateOfBirth, Person.Gender.valueOf(gender), postalCode, city, street, houseNumber);
                } else if (gender != null && !gender.isEmpty() && dateOfBirth != null) {
                    createPerson(name, lastName, dateOfBirth, Person.Gender.valueOf(gender));
                } else {
                    createPerson(name, lastName);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error loading persons from database", e);
        }
    }

    public void savePersonInDB (String firstName, String lastName) {
        String query = "INSERT INTO persons (first_name, last_name) VALUES (?, ?);";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void savePersonInDB(String firstName, String lastName, LocalDate dateOfBirth, Person.Gender gender) {
        String query = "INSERT INTO persons (first_name, last_name, date_of_birth, gender) VALUES (?, ?, ?, ?);";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setDate(3, Date.valueOf(dateOfBirth)); // Convert LocalDate to java.sql.Date
            ps.setString(4, gender.name());
            ps.executeUpdate(); // Use executeUpdate() for INSERT
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void savePersonInDB(String firstName, String lastName, LocalDate dateOfBirth, Person.Gender gender, int postalCode, String city, String street, int houseNumber) {
        String query = "INSERT INTO persons (first_name, last_name, date_of_birth, gender, postal_code, city, street, house_number) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setDate(3, Date.valueOf(dateOfBirth)); // Convert LocalDate to java.sql.Date
            ps.setString(4, gender.name());
            ps.setInt(5, postalCode);
            ps.setString(6, city);
            ps.setString(7, street);
            ps.setInt(8, houseNumber);
            ps.executeUpdate(); // Use executeUpdate() for INSERT
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public Person deletePerson(String firstName, String lastName) {
        String query = "DELETE FROM persons WHERE first_name = ? AND last_name = ?";

        Person personToDelete = null;
        for (Person person : personList) {
            if (person.getFirstName().equalsIgnoreCase(firstName) && person.getLastName().equalsIgnoreCase(lastName)) {
                personToDelete = person;
                break;
            }
        }

        if (personToDelete != null) {
            try {
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setString(1, firstName);
                ps.setString(2, lastName);
                ps.executeQuery();
                personList.remove(personToDelete);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.printf("DELETE: %s %s %s%n", firstName, lastName, personToDelete != null ? " deleted successfully." : " not found.");
        return personToDelete;
    }


    @Override
    protected void add (Person person) {
        try {
            if (person.getAdress() != null) {
                savePersonInDB(person.getFirstName(), person.getLastName(), person.getDateOfBirth(), person.getGender(), person.getAdress().getPostalCode(), person.getAdress().getCity(), person.getAdress().getStreet(), person.getAdress().getHouseNumber());
            } else if (person.getGender() != null && person.getDateOfBirth() != null) {
                savePersonInDB(person.getFirstName(), person.getLastName(), person.getDateOfBirth(), person.getGender());
            } else {
                savePersonInDB(person.getFirstName(), person.getLastName());
            }

            super.add(person);  // add to LIST
        } catch (RuntimeException e) {
            System.out.println("ERROR ADDING PERSON!  >>  " + e.getMessage());
        }
    }
}
