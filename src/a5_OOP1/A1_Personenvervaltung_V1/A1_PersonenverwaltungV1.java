package a5_OOP1.A1_Personenvervaltung_V1;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A1_PersonenverwaltungV1 {
    public static void main(String[] args) {
        PersonnelManagement codersBay = new PersonnelManagement("PV CODERSBAY");
        codersBay.addPerson("Bob", "Smith", "28.01.1900", Person.Gender.male, 1234, "Berlin", "Rotestraße", 75);
        codersBay.addPerson("Ann", "Smith", "08.11.1901", Person.Gender.female);
        codersBay.addPerson("Bob", "Spencer");
        System.out.println(codersBay);

        codersBay.deletePerson("Bob", "Smith");
        codersBay.deletePerson("Bob", "Smith");
        System.out.println(codersBay);

        PersonnelManagement linz = new PersonnelManagement("PV LINZ");
        linz.addPerson("Mickey", "Mouse");
        linz.addPerson("Winnie", "Pooh");
        System.out.println(linz);

        for (Person person : codersBay.getPersonList()) {
            linz.add(person);
        }
        System.out.println(linz);

        linz.deletePerson(1);
        System.out.println(linz);
    }
}
