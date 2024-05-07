package a5_OOP1.A1_Personenvervaltung_V1;
import java.util.ArrayList;
import java.util.List;
class PersonnelManagement {
    public List<Person> personList;
    public String pvName;
    public PersonnelManagement(String pvName) {
        this.personList = new ArrayList<>();
        this.pvName = pvName;
    }

    public void createPerson(String firstName, String lastName, String dateOfBirth, Person.Gender gender, int postalCode, String city, String street, int houseNumber) {
        Person person = new Person(firstName, lastName, dateOfBirth, gender, postalCode, city, street, houseNumber);
        add(person);
    }
    public void createPerson(String firstName, String lastName, String dateOfBirth, Person.Gender gender) {
        Person person = new Person(firstName, lastName, dateOfBirth, gender);
        add(person);
    }
    public void createPerson(String firstName, String lastName) {
        Person person = new Person(firstName, lastName);
        add(person);
    }

    public void add (Person person) {
        personList.add(person);
        System.out.println("ADD to " + pvName + ": " + person.firstName + " " + person.lastName);
    }

    public void deletePerson(String firstName, String lastName) {
        Person personToDelete = null;
        for (Person person : personList) {
            if (person.firstName.equals(firstName) && person.lastName.equals(lastName)) {
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
