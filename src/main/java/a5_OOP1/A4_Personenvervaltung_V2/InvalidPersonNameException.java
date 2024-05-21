package main.java.a5_OOP1.A4_Personenvervaltung_V2;
public class InvalidPersonNameException extends RuntimeException {
    public InvalidPersonNameException(String msg) {
        super(msg);
    }
}