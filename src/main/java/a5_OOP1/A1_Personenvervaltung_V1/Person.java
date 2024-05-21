package main.java.a5_OOP1.A1_Personenvervaltung_V1;
import java.text.MessageFormat;

class Person {
    public String firstName, lastName, dateOfBirth;
    enum Gender {male, female, diverse}
    public Gender gender;
    public Adress adress;

    public Person(String firstName, String lastName, String dateOfBirth, Gender gender, int postalCode, String city, String street, int houseNumber) {
        this.firstName = firstName;
        this.lastName= lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.adress = new Adress(postalCode, city, street, houseNumber);
    }
    public Person(String firstName, String lastName, String dateOfBirth, Gender gender) {
        this.firstName = firstName;
        this.lastName= lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName= lastName;
    }
    @Override
    public String toString() {
        String data = (gender != null ) ? ", gender: " + gender + ", date of birth: " + dateOfBirth : "";
        return MessageFormat.format("Name: {0} {1}{2}.{3}",
                firstName, lastName, data, adress != null ? "\n" + adress : "");
    }
}
