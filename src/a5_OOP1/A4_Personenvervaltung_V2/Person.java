package a5_OOP1.A4_Personenvervaltung_V2;
import java.text.MessageFormat;
import java.time.LocalDate;

class Person {
    private String firstName, lastName;
    private LocalDate dateOfBirth;
    enum Gender {male, female, diverse}
    private Gender gender;
    private Adress adress;

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {

        if (firstName != null && !firstName.isEmpty()) {
            this.firstName = firstName;
        } else {
            throw new IllegalArgumentException("First name cannot be null or empty.");
        }
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        if (lastName != null && !lastName.isEmpty()) {
            this.lastName = lastName;
        } else {
            throw new IllegalArgumentException("Last name cannot be null or empty.");
        }
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(LocalDate dateOfBirth) {
        LocalDate currentDate = LocalDate.now();
        if (dateOfBirth != null && !dateOfBirth.isAfter(currentDate)) {
            this.dateOfBirth = dateOfBirth;
        } else {
            throw new IllegalArgumentException("Date of birth cannot be null or in the future.");
        }
    }

    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
        if (gender != null) {
            this.gender = gender;
        } else {
            throw new IllegalArgumentException("Gender cannot be null.");
        }
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(int postalCode, String city, String street, int houseNumber) {
        Adress newAddress = new Adress();
        try {
            newAddress.setPostalCode(postalCode);
            newAddress.setCity(city);
            newAddress.setStreet(street);
            newAddress.setHouseNumber(houseNumber);
            this.adress = newAddress;
        } catch (IllegalArgumentException e) {
            System.out.println("Failed to set address: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        String data = (gender != null ) ? ", gender: " + gender + ", date of birth: " + dateOfBirth : "";
        return MessageFormat.format("Name: {0} {1}{2}.{3}",
                firstName, lastName, data, adress != null ? "\n" + adress : "");
    }
}
