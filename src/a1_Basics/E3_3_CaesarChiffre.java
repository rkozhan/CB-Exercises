package a1_Basics;

import java.util.Random;
import java.util.Scanner;

public class E3_3_CaesarChiffre {
    public static void main(String[] args) {
        Random r = new Random();
        int key = r.nextInt(1, 27);
        //key = 3;
        System.out.println("gib den Text ein, um ihm zu verschlüsseln");
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        //String text = "Ein Charakter namens Caesar!";

        for (int i = 0; i < text.length(); i++) {
            char letter = text.charAt(i);
            if (letter >= 'A' && letter <= 'Z') {
                letter = (char)(letter + key);
                if (letter > 'Z') {
                    letter = (char)(('A' -1 + letter) % 'Z');
                }
            }
            else if (letter >= 'a' && letter <= 'z') {
                letter = (char)(letter + key);
                if (letter > 'z') {
                    letter = (char)(('a' -1 + letter) % 'z');
                }
            }
            System.out.print(letter);
        }
    }
}

//Mit einer Caesar Chiffre von 6 würde aus dem Text:
//
//Ein Charakter namens Caesar!
//folgendes werden:
//
//Kot Ingxgqzkx tgskty Igkygx!
//wenn wir diesen Text nochmal um 6 verschlüsseln würde aus dem Text:
//
//Quz Otmdmwfqd zmyqze Omqemd!
//Schreibe ein Programm dass von der Konsole einen beliebiglangen Text einliest, danach zufällig einen Schlüssel
// zwischen 1 und 26 wählt und den verschlüsselten String ausgibt.