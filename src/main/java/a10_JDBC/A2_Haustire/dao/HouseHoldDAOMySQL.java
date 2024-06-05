package main.java.a10_JDBC.A2_Haustire.dao;
import main.java.a10_JDBC.A2_Haustire.connector.DBConnector;
import main.java.a10_JDBC.A2_Haustire.model.Household;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class HouseHoldDAOMySQL implements HouseholdDAO {
    private final Connection conn = DBConnector.getInstance().getConnection();

    public void create(Household household) {
        String query = "INSERT INTO households (name) VALUES (?);";
        try (PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            // Insert the new household
            ps.setString(1, household.getName());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int autoId = rs.getInt(1); // Assuming the auto-incremented column is the first column
                household.setId(autoId);
            }
            else  {
                throw new SQLException("No autoincrement ID was generated during INSERT");
            }
        } catch (Exception e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Household read(int id) {
        String query = "SELECT * FROM households WHERE household_id = ?";
        Household household = null;
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                household = new Household(name, id);
            } else throw new SQLException("Error in database query");
        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
        return household;
    }

    public void delete(int id) {
        String query = "DELETE FROM households WHERE household_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, id);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected < 1) throw new SQLException("Error in database query");
        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void update(Household household) {
        String query = "UPDATE households SET name = ? WHERE household_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, household.getName());
            ps.setInt(2, household.getId());
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected < 1) throw new SQLException("Error in database query");
        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Household> getAllHouseHolds() {
        List<Household> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM households");
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String name = rs.getString("name");
                int id = rs.getInt("household_id");
                list.add(new Household(name, id));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error loading from database", e);
        }
        return list;
    }
}
