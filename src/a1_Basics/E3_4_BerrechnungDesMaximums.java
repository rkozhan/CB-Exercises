package a1_Basics;

import java.util.ArrayList;
import java.util.Scanner;

public class E3_4_BerrechnungDesMaximums {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> nums = new ArrayList <>();
        String inputString = "";

        System.out.println("Gib eine liste von Zahlen ein (q zum Abbrechen)");

        do {
            if (sc.hasNextInt()) {
                nums.add(sc.nextInt());
            } else {
                inputString = sc.next();
                if (!inputString.equalsIgnoreCase("q")) System.out.println("Falsche Auswahl!");
            }
        } while (!inputString.equals("q"));

        if (nums.size() > 0) {
            System.out.println(nums);

            int max = 0;
            for (int i = 0; i < nums.size(); i++) {
                if (nums.get(i) > max) {
                    max = nums.get(i);
                }
            }
            System.out.println(max);
        }
    }
}

//Schreibe ein kleines Programm, welches eine Liste von Zahlen über die Konsole zahlenweise einliest. Mit 'q' solltest du
// die Eingabe beenden können. Errechne dir danach aus der eben eingelesenen Liste das Maximum und gib es auf der Konsole aus.