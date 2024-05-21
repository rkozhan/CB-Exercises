package main.java.a5_OOP1.A4_Personenvervaltung_V2;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.Scanner;
public class A4_Personenvervaltung_V2 {
    public static void main(String[] args) {
        PersonnelManagement codersBay = new PersonnelManagement("PV CODERS.BAY");
        //name NULL
        codersBay.createPerson("", "Someone");
        //gender NULL
        codersBay.createPerson("Johann", "Müller", LocalDate.of(1900, 1, 21), null, 1234, "Berlin", "Rotestraße", 75);

// USE SCRIPT TO SIMULATE USER INPUT
        String script = "Max1 abc\n" +  // DIGIT
                "Max Some2one\n" +  // DIGIT
                "Max Someone\n" +
                "Max SomeoneElse\n" +
                "Max Müller 1980-12-31 MALE 101 Wien Stephansplatz 1\n" +  // WHRONG PLZ
                "Max Müller 2980-12-31 MALE 1010 Wien Stephansplatz 1\n" + // WHRONG dateOfBirth
                "Max Müller 1980-12-31 MALE 1010 Wien Stephansplatz 0\n" + // WHRONG houseNum
                "Max Müller 1980-12-31 MALE 1010 Wien Steph....\n" + // something else wrong
                "Maria Schneider 1975-06-15 FEMALE 5020 Salzburg Mozartplatz 5\n" +
                "Thomas Wagner 1992-03-20 male\n" +
                "Sabine Huber 1988-09-25 FEMALE 9020 Klagenfurt Neuerplatz 3\n" +
                "Andreas Mayer 1973-05-10 MALE 6020 Innsbruck Maria-Theresien-Straße 15\n" +
                "q!";
        simulateUserInput(codersBay, script);

        codersBay.showSearchResults("alice");
        codersBay.showSearchResults("max");
        codersBay.deletePerson("max", "noexists");
        codersBay.deletePerson("max", "SomeoneElse");

        codersBay.showSearchResults("max");
    }

    static void simulateUserInput (PersonnelManagement pm, String script) {
        // Создаем фиктивный поток ввода на основе строки
        InputStream inputStream = new ByteArrayInputStream(script.getBytes());

        // Сохраняем стандартный поток ввода
        InputStream originalInput = System.in;
        // Устанавливаем фиктивный поток ввода в качестве стандартного потока ввода
        System.setIn(inputStream);

        Scanner sc = new Scanner(System.in);

        scanString(sc, pm);

        // to default stream input
        System.setIn(originalInput);
        sc.close();
    }

    static void scanString(Scanner sc, PersonnelManagement pm) {
        System.out.println("- - - - - - - - - - - - - - - - ->     Enter first and last name or q! to exit:");
        String input = sc.nextLine();
        System.out.println("> " + input);
        input.trim();

        if (!input.equalsIgnoreCase("q!")) {
            String[] strings = input.split("\\s+");

            if (strings.length >= 2) {
                String firstName = strings[0];
                String lastName = strings[1];

                if (strings.length >= 4) {
                    LocalDate dateOfBirth = LocalDate.parse(strings[2]);
                    Person.Gender gender = Person.Gender.valueOf(strings[3].toUpperCase());

                    if (strings.length >= 8) {
                        int postalCode = Integer.parseInt(strings[4]);
                        String city = strings[5];
                        String street = strings[6];
                        int houseNumber = Integer.parseInt(strings[7]);
                        pm.createPerson(firstName, lastName, dateOfBirth, gender, postalCode, city, street, houseNumber);

                    } else pm.createPerson(firstName, lastName, dateOfBirth, gender);
                } else pm.createPerson(firstName, lastName);
            }
            scanString(sc, pm);
        }
    }
}

//Aufgabe: Personenverwaltung_V2
//Erweitere deine Personenverwaltung um Access Modifier und Datenkapselung

