package a5_OOP1.A4_Personenvervaltung_V2;

import java.text.MessageFormat;

class Adress {
    private int postalCode, houseNumber;
    private String city, street;
/*
    public Adress(int postalCode, int houseNumber, String city, String street) {
        setPostalCode(postalCode);
        setHouseNumber(houseNumber);
        setCity(city);
        setStreet(street);
    }*/

    public int getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(int postalCode) {
        if (String.valueOf(postalCode).length() == 4) {
            this.postalCode = postalCode;
        } else {
            throw new IllegalArgumentException("Postal code must contain 4 digits.");
        }
    }

    public int getHouseNumber() {
        return houseNumber;
    }
    public void setHouseNumber(int houseNumber) {
        if (houseNumber >= 0) {
            this.houseNumber = houseNumber;
        } else {
            throw new IllegalArgumentException("House number must be a non-zero positive integer.");
        }
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        if (city != null && !city.isEmpty()) {
            this.city = city;
        } else {
            throw new IllegalArgumentException("City cannot be null or empty.");
        }
    }

    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        if (street != null && !street.isEmpty()) {
            this.street = street;
        } else {
            throw new IllegalArgumentException("Street cannot be null or empty.");
        }
    }

    @Override
    public String toString() {
        return MessageFormat.format(">> Adress: {0}, {1}, {2} {3}",
                String.valueOf(postalCode), city, street, houseNumber);
    }
}
