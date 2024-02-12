package a2_SortieralgorithmenUndMehrdimensionaleArrays;

import java.util.Arrays;
import java.util.Random;

public class A2_InsertionSort {
    public static void main(String[] args) {
        Random r = new Random();
        //int[] arr = new int[10];                                 //random
        //int[] arr = {9, 7, 5, 3, 1, 0, 2, 4, 6, 8};
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};    // mostly worst case
        //int[] arr = {1, 1, 1, 1, 8, 1, 1, 1, 1, 1};

        for (int i = 0; i < arr.length; i++) {
            //arr[i] = r.nextInt(10);                                //for random
        }
        System.out.println(Arrays.toString(arr));

        int counter = 1;

        for (int i = 1; i < arr.length; i++) {

            int temp = arr[i];
            int k = i;

            while (k > 0 && arr[k -1] > temp) {
                arr[k] = arr[k -1];
                System.out.println(counter++ + " " + Arrays.toString(arr));
                k--;
            }
            arr[k] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
//Implementiere einen Bubble Sort Algorithmus!