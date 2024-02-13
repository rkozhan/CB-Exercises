package a3_Methoden;

public class a0_RekursionChallenge1 {
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
    public int triangle(int rows) {
        if (rows == 0) return 0;
        return rows + triangle(--rows);
    }
    public int sumDigits(int n) {
        if (n < 10) return n;
        return n % 10 + sumDigits(n / 10);
    }
    public int count7(int n) {
        if (n < 10) {
            return n % 10 == 7 ? 1 : 0;
        }
        return n % 10 == 7 ? 1 + count7(n / 10) : count7(n / 10);
    }

}
