package main.java.a10_JDBC.A2_Haustire.model;
import main.java.a10_JDBC.A2_Haustire.dao.PersonDAOMySQL;
import main.java.a10_JDBC.A2_Haustire.dao.PetDAOMySQL;
import org.mariadb.jdbc.Statement;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class Person {
    private int id, houseHoldId;
    private String firstName;
    private List<Pet> petList = null;

    private static PetDAOMySQL sql = new PetDAOMySQL();

    public Person(String firstName) {
       setFirstName(firstName);
    }

    public Person(int id, String firstName) {
        setId(id);
        setFirstName(firstName);
        petList = sql.getAllPets(id);
    }

    public void add (Pet pet) {
        try {
            pet.setPersonId( id);
            sql.create( pet);
            petList.add( pet);
        } catch (RuntimeException e) {
            e.printStackTrace();
            //throw new RuntimeException(e);
        }
    }

    public Pet get (int petId) {
        Pet pet = null;
        try {
            pet = petList.stream()
                    .filter( p -> p.getId() == petId
                            && p.getPersonId() == id)          //TODO upd if personId == id;
                    .findFirst()
                    .orElse(null);
            //household = sql.read(id);
        } catch (RuntimeException e) {
            e.printStackTrace();
            //throw new RuntimeException(e);
        }
        return pet;
    }

    public void delete (int petId) {  //TODO del if houseHoldId == id;

        int index = petList.indexOf( get( petId));
        if (index >= 0) {
            try {
                sql.delete(petId);
                petList.removeIf( pet -> pet.getId() == petId);
            } catch (RuntimeException e) {
                e.printStackTrace();
                //throw new RuntimeException(e);
            }
        } else System.err.println("There are no pet_id " + petId + " in person_id " + this.id);
    }

    public void update (Pet pet) { //TODO upd if houseHoldId == id;
        int index = petList.indexOf( get( pet.getId()));
        if (index >= 0) {
            try {
                pet.setPersonId( id);
                sql.update( pet);
                petList.set( index, pet);
            } catch (RuntimeException e) {
                e.printStackTrace();
                //throw new RuntimeException(e);
            }
        } else System.err.println("There are no pet_id " + pet.getId() + " in person_id " + id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHouseHoldId() {
        return houseHoldId;
    }

    public void setHouseHoldId(int houseHoldId) {
        this.houseHoldId = houseHoldId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public List<Pet> getList () {
        return petList;
    }

    public String toString() {
        return MessageFormat.format("Person {0} (id: {1}, hh_id: {2})", firstName, id, houseHoldId);
    }
}
