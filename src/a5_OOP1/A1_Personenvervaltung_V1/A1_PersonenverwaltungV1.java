package a5_OOP1.A1_Personenvervaltung_V1;

public class A1_PersonenverwaltungV1 {
    public static void main(String[] args) {
        PersonnelManagement codersBay = new PersonnelManagement("PV CODERSBAY");
        codersBay.createPerson("Bob", "Smith", "28.01.1900", Person.Gender.male, 1234, "Berlin", "Rotestraße", 75);
        codersBay.createPerson("Ann", "Smith", "08.11.1901", Person.Gender.female);
        codersBay.createPerson("Bob", "Spencer");
        System.out.println(codersBay);

        codersBay.deletePerson("Bob", "Smith");
        codersBay.deletePerson("Bob", "Smith");
        System.out.println(codersBay);

        PersonnelManagement linz = new PersonnelManagement("PV LINZ");
        linz.createPerson("Mickey", "Mouse");
        linz.createPerson("Winnie", "Pooh");
        System.out.println(linz);

        for (Person person : codersBay.personList) {
            linz.add(person);
        }
        System.out.println(linz);
    }
}

/*
Aufgabe 1: Personenverwaltung
Modelliere und Implementiere eine Personenverwaltung!
Die Klasse Personenverwaltung soll die Möglichkeit bieten Personen anzulegen und Personen zu löschen.
Zum Speichern kannst du gerne eine [Liste](https://docs.oracle.com/javase/7/docs/api/java/util/List.html) verwenden.
Es soll möglich sein, mehrere Personenverwaltungen mit verschiedenen Listen zu erstellen
(z.B. PV Linz, PV Codersbay, PV Magistrat Wien, ...).

⚠️ Ziel ist es nicht in der Main Methode den Person-Konstruktor aufzurufen und diese Personen der Personenverwaltung
zu übergeben! Stattdessen sollte die Personenverwaltung eine Methode `createPerson` bieten über die Personen
mithilfe des Konstruktors der Person erstellt werden können

Personen besitzen verschiedene Eigenschaften u.a. Vorname, Nachname, Geburtsdatum, Adresse, Geschlecht.

Die Klasse Personenverwaltung soll mehrere `create` Methoden zur Erstellung von Personen bieten:

- Eine Person die lediglich mit Vornamen und Nachnamen erstellt wird
- Eine Person die mit allen Werten erstellt wird
- Eine Person die mit Vornamen, Nachnamen, Geschlecht und Geburtstdatum erstellt wird
Versuch für die Abbildung des Geschlechts ein [Java Enum](https://www.w3schools.com/java/java_enums.asp)
zu verwenden. Eine Adresse hat vermutlich auch ihre eigene Klasse verdient da sie aus PLZ, Ort, Straßenname und Hausnummer besteht.
*/
