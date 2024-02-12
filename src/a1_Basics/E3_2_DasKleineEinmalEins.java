package a1_Basics;

public class E3_2_DasKleineEinmalEins {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i + "er Reihe:");

            for (int j = 1; j <= 10; j++) {
                System.out.printf("%d * %d = %d%n", j, i, j * i);
            }
        }
    }
}

//Schreibe mit Hilfe von Schleifen das kleine 1 x 1 auf der Konsole aus. Deine Ausgabe sollte in etwa folgendermaßen aussehen:
//
//1er Reihe:
//1 * 1 = 1
//2 * 1 = 2
//...
//10 * 1 = 10
//2er Reihe:
//1 * 2 = 2
//...
//9 * 10 = 90
//10 * 10 = 100