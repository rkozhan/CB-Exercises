package a5_OOP1.A4_Personenvervaltung_V2;
import java.time.LocalDate;
public class A4_Personenvervaltung_V2 {
    public static void main(String[] args) {
        PersonnelManagement codersBay = new PersonnelManagement();
        codersBay.setPvName("PV CODERS.BAY");

        codersBay.createPerson("Bob", "Smith", LocalDate.of(1900, 1, 21), null, 1234, "Berlin", "Rotestraße", 75);
        codersBay.createPerson("Sam", "Smith", LocalDate.of(1950, 1, 22), Person.Gender.male, 124, "Berlin", "Rotestraße", 75);

        codersBay.createPerson("Ann", "Smith", LocalDate.of(2980, 1, 23), Person.Gender.female);
        codersBay.createPerson("Ann", "Smith", LocalDate.of(1980, 1, 23), null);
        codersBay.createPerson("", "Spencer");
        System.out.println(codersBay);

        codersBay.deletePerson("Bob", "Smith");
        codersBay.deletePerson("Bob", "Smith");
        System.out.println(codersBay);

        PersonnelManagement linz = new PersonnelManagement();
        linz.setPvName("PV LINZ");
        linz.createPerson("Mickey", "Mouse");
        linz.createPerson("Winnie", "Pooh");
        System.out.println(linz);add

    }
}

//Aufgabe: Personenverwaltung_V2
//Erweitere deine Personenverwaltung um Access Modifier und Datenkapselung

