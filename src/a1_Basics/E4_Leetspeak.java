package a1_Basics;

import java.util.HashMap;
import java.util.Scanner;

public class E4_Leetspeak {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String keyToMap = "@8(D3F6#!JK1MN0PQR$7UVWXY2";

        System.out.println("Gib den Text ein");
        //String input; = sc.nextLine();

        String input = "Schreibe ein kleines Programm, welches einen String über die Konsole einliest.";
        // --------------------------------------------------------------------------------------------- mit HashMap

        HashMap<Character, Character> key = new HashMap<Character, Character>();
        int index = 0;
        for (char i = 'a'; i <= 'z'; i++) {
            key.put(i, keyToMap.charAt(index));
            index++;
        }

        StringBuilder output = new StringBuilder();
        input = input.toLowerCase();

        for (int i = 0; i < input.length(); i++) {
            if (key.containsKey(input.charAt(i))) output.append(key.get(input.charAt(i)));
            else output.append(input.charAt(i));
        }

        System.out.println("\n" + output);

        // ---------------------------------------------------------------------------------------------OHNE HashMap
        /*

        StringBuilder output = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) >= 'A' && input.charAt(i) <= 'Z') {
                output.append(keyToMap.charAt(input.charAt(i) - 65));  //A-Z 65-90
            }
            else if (input.charAt(i) >= 'a' && input.charAt(i) <= 'z') {
                output.append(keyToMap.charAt(input.charAt(i) - 97));  //a-z 97-122
            } else output.append(input.charAt(i));
        }
        System.out.println(output);
        */
    }
}

//Schreibe ein kleines Programm, welches einen String über die Konsole einliest. Übersetzte den Text dann in Leetspeak - Du
// darfst dir hier eine beliebige Konfiguration verwenden, falls dir keine einfällt hier ein Vorschlag: Wenn du eine
// andere verwendest bitte in einer Markdown Datei deine Wahl angeben ;)
//
//A => '@' B => '8' C => '(' D => 'D' E => '3' F => 'F' G => '6' H => '#' I => '!' J => 'J' K => 'K' L => '1' M => 'M'
// N => 'N'  O => '0' P => 'P' Q => 'Q' R => 'R' S => '$' T => '7' U => 'U' V => 'V' W => 'W' X => 'X' Y => 'Y' Z => '2'