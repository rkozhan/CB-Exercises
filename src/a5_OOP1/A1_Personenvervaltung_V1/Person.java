package a5_OOP1.A1_Personenvervaltung_V1;
import java.text.MessageFormat;
class Person {
    enum Gender {male, female, diverse}
    private String firstName, lastName, dateOfBirth;
    private Gender gender;
    // für die Adresse
    private Adress adress;

    private int id;

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
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    /*
        // first name
        public String getFirstName() {
            return firstName;
        }
        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }
        // last name
        public String getLastName() {
            return lastName;
        }
        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
        // date of birth
        public String getDateOfBirth() {
            return dateOfBirth;
        }
        public void setDateOfBirth(String dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
        }
        // gender
        public Gender getGender() {
            return gender;
        }
        public void setGender(Gender gender) {
            this.gender = gender;
        }
        // adress
        public Adress getAdress() {
            return adress;
        }
        public void setAdress(Adress adress) {
            this.adress = adress;
        }
        */


    @Override
    public String toString() {
        String data = (gender != null ) ? ", gender: " + gender + ", date of birth: " + dateOfBirth : "";
        return MessageFormat.format("id: {0}, Name: {1} {2}{3}.{4}",
                id, firstName, lastName, data, adress != null ? "\n" + adress : "");
    }
}