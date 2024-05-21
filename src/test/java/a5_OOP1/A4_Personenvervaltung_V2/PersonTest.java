package test.java.a5_OOP1.A4_Personenvervaltung_V2;
import main.java.a5_OOP1.A4_Personenvervaltung_V2.InvalidPersonNameException;
import main.java.a5_OOP1.A4_Personenvervaltung_V2.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class PersonTest {
    private Person person;

    @Test
    void exceptionSetNameTest () {
        assertThrows(InvalidPersonNameException.class, () -> new Person("John99", "Doe"));

        assertThrows(InvalidPersonNameException.class, () -> person = new Person("John", "A7bcd"));
    }
}
