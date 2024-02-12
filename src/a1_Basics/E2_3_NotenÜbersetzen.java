package a1_Basics;

import java.util.Scanner;

public class E2_3_NotenÜbersetzen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Gib eine note ein (von 1 bis 5)");
        int note = sc.nextInt();

        switch (note) {
            case 1 -> {
                System.out.println("Sehr gut");
            }
            case 2 -> {
                System.out.println("Gut");
            }
            case 3 -> {
                System.out.println("Befriedigend");
            }
            case 4 -> {
                System.out.println("Genügend");
            }
            case 5 -> {
                System.out.println("Nicht Gengügend");
            }
            default -> {
                System.out.println(note + " ist keine Note");
            }
        }
    }
}

//Schreibe ein Programm, dass eine Schulnote in numerischer Form (1-5) in seine textuelle Form übersetzt:
//
//Bei einer 1 wird "Sehr gut" auf die Konsole geschrieben
//Bei einer 2 wird "Gut" auf die Konsole geschrieben
//Bei einer 3 wird "Befriedigend" auf die Konsole geschrieben
//Bei einer 4 wird "Genügend" auf die Konsole geschrieben
//Bei einer 5 wird "Nicht Gengügend" auf die Konsole geschrieben