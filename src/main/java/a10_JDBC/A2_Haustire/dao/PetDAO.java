package main.java.a10_JDBC.A2_Haustire.dao;
import main.java.a10_JDBC.A2_Haustire.model.Pet;

public interface PetDAO {
    void create(Pet pet);
    Pet read(int id);
    void delete(int id);
    void update(Pet pet);
}
