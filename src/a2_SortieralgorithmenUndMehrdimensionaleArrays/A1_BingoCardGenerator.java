package a2_SortieralgorithmenUndMehrdimensionaleArrays;

import java.util.ArrayList;
import java.util.Random;

public class A1_BingoCardGenerator {

    // ------------------- OHNE  Mehrdimensionale Arrays
    public static void main(String[] args) {
        Random r = new Random();
        ArrayList<Integer> cardString = new ArrayList<Integer>();

        System.out.println("  B   I   N   G   O");

        for (int i = 0; i < 5; i++) {
            StringBuilder row = new StringBuilder();

            for (int j = 0; j < 5; j++) {
                if (i == 2 && j == 2) {
                    row.append("    ");
                }
                else {
                    int num;
                    do {
                        num = r.nextInt(j * 15 +1, j*15 + 16);
                    } while (cardString.contains(num));
                    cardString.add(num);

                    if (num > 9) row.append(" ").append(num).append(" ");
                    else row.append("  ").append(num).append(" ");
                }
            }
            cardString.clear();
            System.out.println(row);
        }
    }

    // -----------------------Mit Mehrdimensionale Arrays
    /*
    public static void main(String[] args) {
        Random r = new Random();
        int[][] card = new int[5][5];
        ArrayList<Integer> cardString = new ArrayList<Integer>();

        for (int i = 0; i < card.length; i++) {
            for (int j = 0; j < card.length; j++) {
                if (i == 2 && j == 2) {
                   // card[j][i] = null;
                } else {
                    int num;
                    do {
                        num = r.nextInt(j * 15 +1, j*15 + 16);
                    } while (cardString.contains(num));
                    cardString.add(num);
                    card[j][i] = num;
                }
            }
            cardString.clear();
        }

        System.out.println(" B    I    N    G    O");
        for (int i = 0; i < card.length; i++) {
            if (i == 2)
                System.out.printf("%2d | %2d |    | %2d | %2d%n", card[i][0], card[i][1], card[i][3], card[i][4]);
            else
                System.out.printf("%2d | %2d | %2d | %2d | %2d%n", card[i][0], card[i][1], card[i][2], card[i][3], card[i][4]);
        }
    }
     */

    /*
    public static void main(String[] args) {
        Random r = new Random();
        int[][] card = new int[5][5];
        ArrayList<Integer> cardString = new ArrayList<Integer>();

        System.out.println("  B   I   N   G   O");

        for (int i = 0; i < card.length; i++) {
            StringBuilder row = new StringBuilder();

            for (int j = 0; j < card.length; j++) {
                if (i == 2 && j == 2) {
                    row.append("    ");
                }
                else {
                    int num;
                    do {
                        num = r.nextInt(j * 15 +1, j*15 + 16);
                    } while (cardString.contains(num));
                    cardString.add(num);
                    card[j][i] = num;

                    if (num > 9) row.append(" ").append(card[j][i]).append(" ");
                    else row.append("  ").append(card[j][i]).append(" ");
                }
            }
            cardString.clear();
            System.out.println(row);
        }
    }
    */
}

//Die Regeln für eine Bingo-Karte sind einfach: Eine Bingo Karte besteht aus 24 eindeutigen zufälligen Nummern:
//
//5 Zahlen für die B Spalte im Bereich 1 bis 15
//5 Zahlen für die I Spalte im Bereich 16 bis 30
//4 Zahlen für die N Spalte im Bereich 31 bis 45
//5 Zahlen für die G Spalte im Bereich 46 bis 60
//5 Zahlen für die O Spalte im Bereich 61 bis 75
//https://raw.githubusercontent.com/CODERS-BAY/java-06-7-bingo-card-generator-PaulDeveloped/master/bingo.png
//
//Schreibe ein kleines Programm, dass eine Bingo-Karte zufällig erzeugt und formattiert auf die Konsole druckt.