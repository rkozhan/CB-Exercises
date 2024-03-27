package a5_OOP1.A1_Personenvervaltung_V1;
import java.util.ArrayList;
import java.util.List;
class PersonnelManagement {
    private List<Person> personList;
    private String pvName;
    private int idCounter = 1;
    public PersonnelManagement(String pvName) {
        this.personList = new ArrayList<>();
        this.pvName = pvName;
    }

    public void addPerson(String firstName, String lastName, String dateOfBirth, Person.Gender gender, int postalCode, String city, String street, int houseNumber) {
        Person person = new Person(firstName, lastName, dateOfBirth, gender, postalCode, city, street, houseNumber);
        add(person);
    }
    public void addPerson(String firstName, String lastName, String dateOfBirth, Person.Gender gender) {
        Person person = new Person(firstName, lastName, dateOfBirth, gender);
        add(person);
    }
    public void addPerson(String firstName, String lastName) {
        Person person = new Person(firstName, lastName);
        add(person);
    }

    public void add (Person person) {
        personList.add(person);
        person.setId(idCounter++);
        System.out.println("ADD to " + pvName + ": " + person.getFirstName() + " " + person.getLastName());
    }

    public void deletePerson(String firstName, String lastName) {
        Person personToDelete = null;
        for (Person person : personList) {
            if (person.getFirstName().equals(firstName) && person.getLastName().equals(lastName)) {
                personToDelete = person;
                break;
            }
        }
        String res = " not found.";
        if (personToDelete != null) {
            personList.remove(personToDelete);
            res = " deleted successfully.";
        }
        System.out.println("DELETE from " + pvName + ": " + firstName + " " + lastName + res);
    }

    public void deletePerson(int id) {
        Person personToDelete = null;
        for (Person person : personList) {
            if (person.getId() == id) {
                personToDelete = person;
                break;
            }
        }
        String res = " not found.";
        if (personToDelete != null) {
            personList.remove(personToDelete);
            res = " deleted successfully.";
        }
        System.out.println("DELETE from " + pvName + ": id " + id + res);
    }
    public List<Person> getPersonList() {
        return personList;
    }
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("\n" + pvName + ":\n");
        for (Person person : personList) {
            result.append(person.toString()).append("\n");
        }
        return result.toString();
    }
}