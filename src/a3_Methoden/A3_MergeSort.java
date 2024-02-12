package a3_Methoden;

import java.util.Arrays;

public class A3_MergeSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(mergeSort(new int[]{14, 7, 3, 12, 9, 11, 6, 2})));
        System.out.println(Arrays.toString(mergeSort(new int[]{3, 2, 5 , 7, 4})));
        System.out.println(Arrays.toString(mergeSort(new int[]{8, 2, 4 , 1, 3})));
        System.out.println(Arrays.toString(mergeSort(new int[]{5, 1, 8, 3, 9, 2})));
    }
    static int[] mergeSort (int[] arr) {

        if (arr.length > 1) {
            int[] left = new int[arr.length / 2];
            int[] right = new int[arr.length - arr.length / 2];

            for (int i = 0; i < arr.length; i++) {
                if (i < left.length) left[i] = arr[i];
                else right[i - left.length] = arr[i];
            }

            mergeSort(left);
            mergeSort(right);

            int a = 0, l = 0, r = 0;

            while (l < left.length && r < right.length) {
                if (left[l] < right[r]) arr[a++] = left[l++];
                else arr[a++] = right[r++];
            }
            while (l < left.length ) {
                arr[a++] = left[l++];
            }
            while (r < right.length) {
                arr[a++] = right[r++];
            }
        }
        return arr;
    }
}
