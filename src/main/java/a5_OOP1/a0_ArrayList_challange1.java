package main.java.a5_OOP1;
import java.util.ArrayList;
import java.util.Scanner;
public class a0_ArrayList_challange1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> nums = new ArrayList <>();
        String inputString = "";

        System.out.println("Gib eine liste von Zahlen ein (Q zum Abbrechen)");

        do {
            if (sc.hasNextInt()) {
                nums.add(sc.nextInt());
            } else {
                inputString = sc.next();
                if (!inputString.equalsIgnoreCase("q")) System.out.println("Falsche Auswahl!");
            }
        } while (!inputString.equals("q"));

        int max = Integer.MIN_VALUE;
        if (nums.size() > 0) {
            for (int i : nums) {
                if (i > max) max = i;
            }

            for (int i : nums) {
                System.out.println(i != max ? i : i + " <== largest value");
            }
        }
    }
}
/*
ArrayList Challenge 1
Schreibe ein Programm das vom User int Werte als Input akzeptiert, solange der User nicht Q für “Quit” eingibt.
Hat der User das Programm beendet sollen alle Zahlen, die in einer ArrayList gespeichert werden soll,
ausgegeben werden und die höchste Zahl soll dabei markiert werden.
 */