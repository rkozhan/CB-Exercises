package a2_SortieralgorithmenUndMehrdimensionaleArrays;

import java.util.Arrays;
import java.util.Random;

public class A4_SelectionSort {
    public static void main(String[] args) {
        Random r = new Random();
        int[] arr = {9, 7, 5, 3, 1, 0, 2, 4, 6, 8};
        System.out.println(Arrays.toString(arr));

        int counter = 1;

        for (int i = 0; i < arr.length -1; i++) {
            int indexOfMin = i;

            for (int k = i +1; k < arr.length; k++) {   //  search min in (from arr[i] to arr[arr.length] )
                if (arr[k] < arr[indexOfMin]) {
                    indexOfMin = k;
                    System.out.println("index " + indexOfMin);
                }
            }

            if (arr[i] != arr[indexOfMin]) {
                int temp = arr[i];
                arr[i] = arr[indexOfMin];
                arr[indexOfMin] = temp;

                System.out.println(counter++ + " " + Arrays.toString(arr));
            }

        }
        //System.out.println(Arrays.toString(arr));
    }
}

//Implementiere einen Selection Sort Algorithmus!