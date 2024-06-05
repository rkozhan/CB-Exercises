package main.java.a10_JDBC.A2_Haustire.dao;
import main.java.a10_JDBC.A2_Haustire.connector.DBConnector;
import main.java.a10_JDBC.A2_Haustire.model.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDAOMySQL implements PersonDAO {
    private final Connection conn = DBConnector.getInstance().getConnection();

    public void create(Person person) {
        String query = "INSERT INTO h_persons (first_name, household_id) VALUES (?, ?);";
        try (PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, person.getFirstName());
            ps.setInt(2, person.getHouseHoldId());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int autoId = rs.getInt(1); // Assuming the auto-incremented column is the first column
                person.setId(autoId);
            }
        } catch (Exception e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Person read(int id) {
        Person person = null;
        String query = "SELECT * FROM h_persons WHERE person_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int houseHoldId = rs.getInt("household_id");
                String name = rs.getString("first_name");
                person = new Person(id, name);
                person.setHouseHoldId(houseHoldId);
            } else throw new SQLException("Error in database query");
        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
        return person;
    }

    public void delete(int id) {
        String query = "DELETE FROM h_persons WHERE person_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, id);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected < 1) throw new SQLException("Error in database query");
        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void update(Person person) {
        String query = "UPDATE h_persons SET first_name = ?, household_id = ? WHERE person_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, person.getFirstName());
            ps.setInt(2, person.getHouseHoldId());
            ps.setInt(3, person.getId());
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected < 1) throw new SQLException("Error in database query");
        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Person> getAllPersons (int houseHoldId) {
        List<Person> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM h_persons WHERE household_id = ?")) {
            ps.setInt(1, houseHoldId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int personId = rs.getInt("person_id");
                String name = rs.getString("first_name");
                Person person = new Person(personId, name);
                person.setHouseHoldId(houseHoldId);
                list.add(person);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }


}


