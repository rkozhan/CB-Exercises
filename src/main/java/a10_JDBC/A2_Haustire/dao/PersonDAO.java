package main.java.a10_JDBC.A2_Haustire.dao;
import main.java.a10_JDBC.A2_Haustire.model.Person;

public interface PersonDAO {
    void create(Person person);
    Person read(int id);
    void delete(int id);
    void update(Person person);
}
