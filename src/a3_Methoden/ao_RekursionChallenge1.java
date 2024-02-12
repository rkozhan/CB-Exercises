package a3_Methoden;

public class ao_RekursionChallenge1 {
    public static void main(String[] args) {
        upToHundred(90);
        System.out.println();
        System.out.println(addNumbersRecursive(5));
    }
    static void  upToHundred(int n) {
        if (n > 100) return;
        //while (n <= 100) {  // ohne Rekursion muss eine Schleife verwenden werden
        System.out.print(n + ", ");
           // n++;
        //}
        upToHundred(n + 1);
    }
    static int  addNumbersRecursive (int n) {
        if (n > 0) n += addNumbersRecursive(n - 1);
        return n;
    }
}
