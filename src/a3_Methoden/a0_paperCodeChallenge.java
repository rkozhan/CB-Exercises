package a3_Methoden;

import java.util.ArrayList;

public class a0_paperCodeChallenge {
    public static void main(String[] args) {
        /*

        // --------------------------- Magisches Quadrat
        int[][] arr = {
                {2,7,6},
                {9,5,1},
                {4,3,8}
        };
        int diag1 = 0, diag2 = 0;
        boolean isMagic = false;

        for (int i = 0; i < arr.length; i++) {
            diag1 += arr[i][i];
            diag2 += arr[i][arr.length -1 -i];
        }

        if (diag1 == diag2) isMagic = true;

        for (int i = 0; i < arr.length && isMagic; i++) {
            int row = 0, col = 0;

            for (int j = 0; j < arr.length; j++) {
                row += arr[j][i];
                col += arr[i][j];
            }

            if (row != diag1 || col != diag1) isMagic = false;
        }
        System.out.println(isMagic ? "Dieses Quadrat ist magisch" : "Dieses Quadrat ist nicht magisch");

        */
        // --------------------------- Quersumme
        int num = 2024, qSum = 0;

        while (num > 0) {
            qSum += num % 10;
            num /= 10;
        };

        System.out.println(qSum);
    }
}
