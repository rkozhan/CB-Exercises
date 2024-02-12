package a1_Basics;

import java.util.Scanner;

public class E2_1_EigenschaftenEinerZahl {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int happyNum = 123;

        int num = sc.nextInt();

        System.out.println( num % 10 == 0 ? "- ist eine runde Zahl" : "- ist keine runde Zahl");
        System.out.println( num % 2 == 0 ? "- ist gerade" : "- ist ungerade");
        System.out.println( num == happyNum ? "- entspricht meiner Glückszahl" : "- entspricht meiner Glückszahl nicht");
        System.out.println( num >= -9 && num <= 9 ? "- ist nicht zweistellig" : "ist zweistellig");
    }
}


//Schreibe ein Programm, dass von der Konsole eine Zahl einliest und ausgibt:
//
//ob es sich um eine runde Zahl handelt
//ob die Zahl gerade ist
//ob die Zahl deiner Glückszahl entspricht (denk dir hierfür einfach eine eigene Glückszahl aus und gib sie zu Beginn des Programms auf der Konsole aus)
//ob die Zahl zweistellig ist