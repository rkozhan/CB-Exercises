package main.java.a10_JDBC.A2_Haustire.model;
import java.text.MessageFormat;
public class Pet {
    private int id, personId;
    private String name;

    public Pet(String name) {
        setName(name);
    }

    public Pet(int id, String name) {
        setId(id);
        setName(name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return MessageFormat.format("Pet {0} (id: {1}, owner_id: {2})", name, id, personId);
    }

}


