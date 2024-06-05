package main.java.a10_JDBC.A2_Haustire.model;
import main.java.a10_JDBC.A2_Haustire.dao.PersonDAOMySQL;
import java.text.MessageFormat;
import java.util.List;

public class Household {
    private String name;
    private int id;
    private List<Person> personList = null;
    private static PersonDAOMySQL sql = new PersonDAOMySQL();
    public Household(String name) {
        setName(name);
    }
    public Household (String name, int id) {
        setName( name);
        setId(id);
        personList = sql.getAllPersons(id);
    }

    public void add (Person person) {
        try {
            person.setHouseHoldId( id);
            sql.create( person);
            personList.add( person);
        } catch (RuntimeException e) {
            e.printStackTrace();
            //throw new RuntimeException(e);
        }
    }

    public Person get (int personId) {
        Person person = null;
        try {
            person = personList.stream()
                    .filter( h -> h.getId() == personId
                        && h.getHouseHoldId() == id)          //TODO upd if houseHoldId == id;
                    .findFirst()
                    .orElse(null);
            //household = sql.read(id);
        } catch (RuntimeException e) {
            e.printStackTrace();
            //throw new RuntimeException(e);
        }
        return person;
    }

    public void delete (int personId) {  //TODO del if houseHoldId == id;

        int index = personList.indexOf( get( personId));
        if (index >= 0) {
            try {
                sql.delete(personId);
                personList.removeIf( person -> person.getId() == personId);
            } catch (RuntimeException e) {
                e.printStackTrace();
                //throw new RuntimeException(e);
            }
        } else System.err.println("There are no person_id " + personId + " in household_id " + this.id);
    }

    public void update (Person person) { //TODO upd if houseHoldId == id;
        int index = personList.indexOf( get( person.getId()));
        if (index >= 0) {
            try {
                    person.setHouseHoldId( id);
                    sql.update( person);
                    personList.set( index, person);
            } catch (RuntimeException e) {
                e.printStackTrace();
                //throw new RuntimeException(e);
            }
        } else System.err.println("There are no person_id " + person.getId() + " in household_id " + id);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public List<Person> getList () {
        return personList;
    }

    @Override
    public String toString() {
        return MessageFormat.format("{0} (id: {1})", name, id);
    }
}
