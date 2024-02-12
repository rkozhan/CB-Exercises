package a3_Methoden;

import java.util.Arrays;

public class A2_DivideConquer {
    public static void main(String[] args) {
        //int[] arr = {14, 7, 3, 12, 9, 11, 6, 2};
        int[] arr = {1, 2, 3, 0, 1};

        System.out.println(maxFind(arr));
    }
    static int maxFind (int[] arr) {

        int max = arr[0];

        if (arr.length > 1) {
            int[] left = new int[arr.length / 2];
            int[] right = new int[arr.length - arr.length / 2];

            for (int i = 0; i < arr.length; i++) {
                if (i < left.length) left[i] = arr[i];
                else right[i - left.length] = arr[i];
            }
            if (arr.length > 2) {
                if (max < Math.max(maxFind(right), maxFind(left))) max = Math.max(maxFind(left), maxFind(right));
            } else {
                if (max < Math.max(left[0], right[0])) max = Math.max(left[0], right[0]);
            }
            System.out.println(max);

            System.out.println("left " + Arrays.toString(left));
            System.out.println("right " + Arrays.toString(right));
        }
        return max;
    }
}
