package a3_Methoden;

import java.util.Arrays;

public class A2_DivideConquer {
    public static void main(String[] args) {
        int[] arr = {14, 7, 3, 12, 9, 11, 6, 2};
        //int[] arr = {1, 2, 3, 0, 1};
        //int[] arr = {};

        System.out.println("max: " + maxFind(arr));
    }
    static int maxFind (int[] arr) {
        if (arr.length == 0) return 0;
        else {
            int max = arr[0];

            if (arr.length > 1) {
                int[] left = Arrays.copyOfRange(arr, 0, arr.length / 2);
                int[] right = Arrays.copyOfRange(arr, arr.length / 2, arr.length);

                if (arr.length > 2 && max < Math.max(maxFind(right), maxFind(left)))
                    max = Math.max(maxFind(left), maxFind(right));
                else max = Math.max(max, right[0]);

                //System.out.println(max);
                //System.out.println("left " + Arrays.toString(left));
                //System.out.println("right " + Arrays.toString(right));
            }
            return max;
        }
    }
}
