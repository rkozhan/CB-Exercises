package a1_Basics;

public class E3_1_OachkatzlSchwoaf {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0)
                System.out.println("OachkatzlSchwoaf !!!");
            else if (i % 3 == 0)
                System.out.println("Oachkatzl !!!");
            else if (i % 5 == 0)
                System.out.println("Schwoaf !!!");
            else
                System.out.println(i);
        }
    }
}

//OachkatzlSchwoaf ist ein Spiel um Kindern Division näher zu bringen. Die Regeln sind einfach -
// Reih um wird beginnend bei der Zahl 1 nach oben gezählt. Ist die Zahl durch drei teilbar, darf die Zahl allerdings
// nicht genannt werden - man muss Oachkatzl sagen, ist die Zahl durch fünf teilbar muss Schwoaf gesagt werden.
// Und - ist die Zahl durch drei und fünf teilbar, muss OachkatzlSchwoaf gesagt werden.
//
//Schreibe ein Programm, dass die Zahlen von 1 - 100 nach diesem Schema ausgibt.
// Du musst die Zahlen nicht in Wortform ausgeben, numerisch reicht.