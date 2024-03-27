package a5_OOP1.A1_Personenvervaltung_V1;

import java.text.MessageFormat;

class Adress {
    private int postalCode;
    private int houseNumber;
    private String city;
    private String street;

    public Adress(int postalCode, String city, String street, int houseNumber) {
        this.postalCode = postalCode;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
    }
    /*
    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
    */
    @Override
    public String toString() {
        return MessageFormat.format(">> Adress: {0}, {1}, {2} {3}",
                String.valueOf(postalCode), city, street, houseNumber);
    }
}