package a5_OOP1.A4_Personenvervaltung_V2;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class PersonnelManagement {
    private final List<Person> personList;
    private String pvName;
    PersonnelManagement() {
        this.personList = new ArrayList<>();
    }

    public void createPerson(String firstName, String lastName, LocalDate dateOfBirth, Person.Gender gender, int postalCode, String city, String street, int houseNumber) {
        try {
            Person person = new Person(firstName, lastName, dateOfBirth, gender, postalCode, city, street, houseNumber);
            add(person);
        } catch (IllegalArgumentException e) {
            System.err.println("Error creating person: " + e.getMessage());
        }
    }

    public void createPerson(String firstName, String lastName, LocalDate dateOfBirth, Person.Gender gender) {
        try {
            Person person = new Person(firstName, lastName, dateOfBirth, gender);
            add(person);
        } catch (IllegalArgumentException e) {
            System.err.println("Error creating person: " + e.getMessage());
        }
    }
    public void createPerson(String firstName, String lastName) {
        //Person person = new Person();  //instead this -> constructor in "Person"
        try {
            Person person = new Person(firstName, lastName);
            /*
            person.setFirstName(firstName);
            person.setLastName(lastName);
             */
            add(person);
        } catch (IllegalArgumentException e) {
            System.err.println("Error creating person: " + e.getMessage());
        }
    }
    private void add (Person person) {
        personList.add(person);
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

    public String getPvName() {
        return pvName;
    }
    public void setPvName(String pvName) {
        this.pvName = pvName;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("\n" + pvName + ":\n");
        for (Person person : personList) {
            result.append(person.toString()).append("\n");
        }
        return result.toString();
    }
}
