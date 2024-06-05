package main.java.a10_JDBC.A2_Haustire.dao;
import main.java.a10_JDBC.A2_Haustire.connector.DBConnector;
import main.java.a10_JDBC.A2_Haustire.model.Pet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PetDAOMySQL implements PetDAO {
    private final Connection conn = DBConnector.getInstance().getConnection();

    public void create(Pet pet) {
        String query = "INSERT INTO pets (name, person_id) VALUES (?, ?);";
        try (PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, pet.getName());
            ps.setInt(2, pet.getPersonId());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int autoId = rs.getInt(1); // Assuming the auto-incremented column is the first column
                pet.setId(autoId);
            }
        } catch (Exception e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Pet read(int id) {
        Pet pet = null;
        String query = "SELECT * FROM pets WHERE pet_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String name = rs.getString("name");
                int personId = rs.getInt("person_id");
                pet = new Pet(id, name);
                pet.setPersonId(personId);
            } else throw new SQLException("Error in database query");
        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
        return pet;
    }

    public void delete(int id) {
        String query = "DELETE FROM pets WHERE pet_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, id);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected < 1) throw new SQLException("Error in database query");
        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void update(Pet pet) {
        String query = "UPDATE pets SET name = ?, person_id = ? WHERE pet_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, pet.getName());
            ps.setInt(2, pet.getPersonId());
            ps.setInt(3, pet.getId());
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected < 1) throw new SQLException("Error in database query");
        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Pet> getAllPets (int person_id) {
        List<Pet> list = new ArrayList<>();
        String query = "SELECT * FROM pets WHERE person_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, person_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int petId = rs.getInt("pet_id");
                String name = rs.getString("name");
                Pet pet = new Pet(petId, name);
                pet.setPersonId(person_id);
                list.add(pet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}


