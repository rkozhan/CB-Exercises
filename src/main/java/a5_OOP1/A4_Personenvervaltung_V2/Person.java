package main.java.a5_OOP1.A4_Personenvervaltung_V2;

import java.text.MessageFormat;
import java.time.LocalDate;

public class Person {
    private String firstName, lastName;
    private LocalDate dateOfBirth;
    public enum Gender {MALE, FEMALE, DIVERSE}
    private Gender gender;
    private Adress adress;
    // =============================================== CONSTRUCTORS


    public Person(String firstName, String lastName, LocalDate dateOfBirth, Person.Gender gender, int postalCode, String city, String street, int houseNumber) {
        setFirstName(firstName);
        setLastName(lastName);
        setGender(gender);
        setDateOfBirth(dateOfBirth);
        setAdress(new Adress(postalCode, houseNumber, city, street));
    }
    public Person(String firstName, String lastName, LocalDate dateOfBirth, Person.Gender gender) {
        setFirstName(firstName);
        setLastName(lastName);
        setGender(gender);
        setDateOfBirth(dateOfBirth);
    }
    public Person(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
    }
// VALIDATE
    public void validateName(String name, String fieldName) {
        if (name == null || name.isEmpty()) throw new IllegalArgumentException(fieldName + " Name cannot be null or empty.");

        // ===============================================FOR EXCEPTIONS EXERCISE
        if (name.matches(".*\\d.*")) throw new InvalidPersonNameException(fieldName + " Name cannot contain digits: " + name);
    }

    public void validate(LocalDate dateOfBirth) {
        LocalDate currentDate = LocalDate.now();
        if (dateOfBirth == null || dateOfBirth.isAfter(currentDate)) throw new IllegalArgumentException("Date of birth cannot be null or in the future.");
    }
    public void validate(Person.Gender gender) {
        if (gender == null) throw new IllegalArgumentException("Gender cannot be null.");
    }

    // ================================================== SETTERS
    public void setFirstName(String firstName) {
        validateName(firstName, "First");
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        validateName(lastName, "Last");
        this.lastName = lastName;

    }
    public void setDateOfBirth(LocalDate dateOfBirth) {
        validate(dateOfBirth);
        this.dateOfBirth = dateOfBirth;
    }
    public void setGender(Gender gender) {
        validate(gender);
        this.gender = gender;
    }
    public void setAdress(Adress adress) {
        this.adress = adress;
    }


    // ============================== GETTERS
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public Gender getGender() {
        return gender;
    }

    public Adress getAdress() {
        return adress;
    }

    @Override
    public String toString() {
        String data = (gender != null ) ? ", gender: " + gender + ", date of birth: " + dateOfBirth : "";
        return MessageFormat.format("Name: {0} {1}{2}.{3}",
                firstName, lastName, data, adress != null ? "\n" + adress : "");
    }
}
