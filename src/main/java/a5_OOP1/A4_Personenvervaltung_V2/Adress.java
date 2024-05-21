package main.java.a5_OOP1.A4_Personenvervaltung_V2;

import java.text.MessageFormat;

class Adress {
    private int postalCode, houseNumber;
    private String city, street;

    public Adress(int postalCode, int houseNumber, String city, String street) {
        setPostalCode(postalCode);
        setHouseNumber(houseNumber);
        setCity(city);
        setStreet(street);
    }
    // ================================================== VALIDATE Methods
    private void validate(String string, String typeOf) {
        if (string == null || string.isEmpty()) throw new IllegalArgumentException(typeOf + " cannot be null or empty.");
    }
    private void validate(int houseNumber) {
        if (houseNumber < 1) throw new IllegalArgumentException("House number must be a non-zero positive integer.");
    }
    private void validateZipCode(int postalCode) {
        if (String.valueOf(postalCode).length() != 4) throw new IllegalArgumentException("Postal code must contain 4 digits.");
    }


    // ================================================== SETTERS
    public void setPostalCode(int postalCode) {
        validateZipCode(postalCode);
        this.postalCode = postalCode;
    }
    public void setHouseNumber(int houseNumber) {
        validate(houseNumber);
        this.houseNumber = houseNumber;
    }
    public void setCity(String city) {
        validate(city, "city");
        this.city = city;
    }
    public void setStreet(String street) {
        validate(street, "street");
        this.street = street;
    }


    // ============================== GETTERS
    public int getPostalCode() {
        return postalCode;
    }
    public int getHouseNumber() {
        return houseNumber;
    }
    public String getCity() {
        return city;
    }
    public String getStreet() {
        return street;
    }


    @Override
    public String toString() {
        return MessageFormat.format(" -   Adress: {0}, {1}, {2} {3}",
                String.valueOf(postalCode), city, street, houseNumber);
    }
}
