package test.java.a5_OOP1.A4_Personenvervaltung_V2;
import main.java.a5_OOP1.A4_Personenvervaltung_V2.PersonnelManagement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class PersonnelManagementTest {
    private PersonnelManagement pm;
    @BeforeEach
    void setUp() {
        pm = new PersonnelManagement("test PM");
        pm.createPerson("Max", "LastName");
        pm.createPerson("Max", "SomeLastName");
        pm.createPerson("Donald", "Someone");
    }

    @Test
    void ExeptionFindPersonsTest () {
        assertThrows(NullPointerException.class, () -> pm.searchPersonsByName("Bob"));
    }
}
