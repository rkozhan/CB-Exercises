package a2_SortieralgorithmenUndMehrdimensionaleArrays;

import java.util.Arrays;
import java.util.Random;

public class A3_BubleSort {
    public static void main(String[] args) {
        Random r = new Random();
        //int[] arr = new int[10];

        int[] arr = {9, 7, 5, 3, 1, 0, 2, 4, 6, 8};

        for (int i = 0; i < arr.length; i++) {
            //arr[i] = r.nextInt(10);                                //for random
        }
        System.out.println(Arrays.toString(arr));

        int counter = 1;

        for (int i = arr.length -1; i > 1; i--) {   // i > 1 passt

            for (int k = 0; k < i; k++) {
                if (arr[k] > arr[k +1]) {
                    int temp = arr[k +1];
                    arr[k +1] = arr[k];
                    arr[k] = temp;

                    System.out.println(counter++ + " " + Arrays.toString(arr));
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}

//Implementiere einen Bubble Sort Algorithmus!
