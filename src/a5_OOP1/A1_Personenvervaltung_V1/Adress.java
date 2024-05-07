package a5_OOP1.A1_Personenvervaltung_V1;
import java.text.MessageFormat;
class Adress {
    public int postalCode, houseNumber;
    public String city, street;
    public Adress(int postalCode, String city, String street, int houseNumber) {
        this.postalCode = postalCode;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
    }
    @Override
    public String toString() {
        return MessageFormat.format(">> Adress: {0}, {1}, {2} {3}",
                String.valueOf(postalCode), city, street, houseNumber);
    }
}
