package main.java.a9_file_IO_and_Exceptions.A1_Exceptions;
        /*
    void addPersonsFromInput () {
        String userInput = "";
        do {
            System.out.println("Enter first name:");
            String firstName = new Scanner(System.in).nextLine();
            System.out.println("Enter last name:");
            String lastName = new Scanner(System.in).nextLine();

        } while (userInput != "q!");
    }

         */


// SEE a5_OOP1 / A4_Personenvervaltung_V2
/*
Aufgabe: Erweitere die Personenverwaltung um Exceptions

Die, in der früheren Aufgabe erstellte, Personenverwaltung, soll nun etwas sicherer für Fehler gemacht werden.
Erweitere den Code so, dass der User die Personen mit Hilfe eines Scanners erstellt oder alternativ ein Skript (in der main methode) erstellt wird um die Eingaben zu simulieren.
Dabei soll auf ungültige Inputs vernünftig reagiert werden, ohne dass das Programm abstürzt.
Requirements

InvalidPersonName-Exception
Wenn ein Nutzer eine Person anlegt, die eine Zahl im Namen hat, soll eine "InvalidPersonName-Exception" geworfen werden.
Die Anlegung des Objektes soll abgebrochen werden und der Nutzer informiert, dass dieser Name ungültig ist.
Das Programm soll nicht terminieren, sondern den Nutzer erneut bitten einen Namen einzugeben.
NullpointerException
Der Nutzer soll Personen durch ihren Namen finden können.
Wird ein Name eingegeben, der nicht existiert, soll eine NullpointerException in der Personalverwaltung geworfen werden.
Der Stacktrace dieser Exception soll in der Main ausgegeben werden.
Das Programm soll nicht terminieren und weitere Inputs erhalten.
Test
Option 1: Das Programm ist durch die Eingabe von ":q!" terminierbar.

Option 2: Du schreibst entsprechende Unittests, um zu prüfen, dass die richtige Exception geworfen wird.
 */