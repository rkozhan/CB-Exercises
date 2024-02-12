package a1_Basics;

import java.util.Scanner;

public class E2_2_ArbeitsOderFreizeit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hour, minute;

        do {
            System.out.println("Gib die Stunde ein (Zahl von 0 bis 23)");
            hour = sc.nextInt();
        } while (hour < 0 || hour > 23);

        do {
            System.out.println("Gib die Minuten ein (Zahl von 0 bis 59)");
            minute = sc.nextInt();
        } while (minute < 0 || minute > 59);

        if (hour > 9 && hour < 15
                || hour == 8 && minute >= 30
                ||  hour == 15 && minute <= 30) {
            System.out.printf("%02d:%02d Uhr liegt in der Arbeitszeit", hour, minute);
        } else
            System.out.printf("%02d:%02d Uhr liegt nicht in der Arbeitszeit", hour, minute);

        if (hour == 12 && minute == 0) System.out.println("Es ist Mittag");
    }
}

//In der CODERS.BAY arbeiten wir von 8:30 bis 15:30 Uhr. Schreibe ein Programm,
// dass eine Zahl von der Konsole einliest und ausgibt ob die Stunde in der Arbeitszeit liegt oder nicht.
//
//Bonus: von 12:00 bis 12:30 Uhr ist immer Mittagspause, gib also in der Zeit aus, dass Mittag ist.


