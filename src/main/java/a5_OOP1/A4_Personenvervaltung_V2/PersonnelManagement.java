package main.java.a5_OOP1.A4_Personenvervaltung_V2;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonnelManagement {
    protected final List<Person> personList;
    private String pvName;
    public PersonnelManagement(String pvName) {
        this.personList = new ArrayList<>();
        setPvName(pvName);
    }

    public void createPerson(String firstName, String lastName, LocalDate dateOfBirth, Person.Gender gender, int postalCode, String city, String street, int houseNumber) {
        try {
            Person person = new Person(firstName, lastName, dateOfBirth, gender, postalCode, city, street, houseNumber);
            add(person);
        } catch (IllegalArgumentException e) {
            showErrorMessage(e.getMessage());
        }
    }

    public void createPerson(String firstName, String lastName, LocalDate dateOfBirth, Person.Gender gender) {
        try {
            Person person = new Person(firstName, lastName, dateOfBirth, gender);
            add(person);
        } catch (IllegalArgumentException e) {
            showErrorMessage(e.getMessage());
        }
    }
    public void createPerson(String firstName, String lastName) {
        try {
            Person person = new Person(firstName, lastName);
            add(person);
        } catch (IllegalArgumentException e) {
            showErrorMessage(e.getMessage());
        }
    }
    private void showErrorMessage (String msg) {
        System.out.println("ERROR CREATING PERSON!  >>  " + msg);
    }
    protected void add (Person person) {
        personList.add(person);
        System.out.println("ADD to " + pvName + ": " + person.getFirstName() + " " + person.getLastName());
    }

    public Person deletePerson(String firstName, String lastName) {
        Person personToDelete = null;
        for (Person person : personList) {
            if (person.getFirstName().equalsIgnoreCase(firstName) && person.getLastName().equalsIgnoreCase(lastName)) {
                personToDelete = person;
                break;
            }
        }
        if (personToDelete != null) personList.remove(personToDelete);

        System.out.printf("DELETE: %s %s %s%n", firstName, lastName, personToDelete != null ? " deleted successfully." : " not found.");
        return personToDelete;
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



    // ===============================================FOR EXCEPTIONS EXERCISE
    public List<Person> searchPersonsByName (String firstName) {
        List<Person> persons = personList.stream()
                        .filter(person -> person.getFirstName().equalsIgnoreCase(firstName))
                        .toList();
        if (persons.isEmpty()) throw new NullPointerException("No persons found with the first name: " + firstName);
        return persons;
    }

    public void showSearchResults (String firstName) {
        System.out.println("SEARCH RESULT: " + firstName);
        try {
            searchPersonsByName(firstName)
                    .forEach(person ->
                            System.out.println(person.getFirstName() + " " +person.getLastName()));
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
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
