package a2_SortieralgorithmenUndMehrdimensionaleArrays;

import java.util.Arrays;
import java.util.Random;

public class A5_CompareSortAlgoritms {
    public static void main(String[] args) {
        Random r = new Random();
        int size = 1000;
        int tries = 1000, t;
        int randomMax = 101;

        // -----------------------------------------------  insertion sort
        t = tries;
        long time1 = System.currentTimeMillis();
        while (t > 0) {
            int[] arr = new int[size];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = r.nextInt(randomMax);
            }

            for (int i = 1; i < arr.length; i++) {
                int temp = arr[i];
                int k = i;

                while (k > 0 && arr[k -1] > temp) {
                    arr[k] = arr[k -1];
                    k--;
                }
                arr[k] = temp;
            }

            t--;
        }
        long timeOfInsertion = System.currentTimeMillis() - time1;

        // -----------------------------------------------  bubble sort
        t = tries;
        long time2 = System.currentTimeMillis();
        while (t > 0) {
            int[] arr = new int[size];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = r.nextInt(randomMax);
            }

            for (int i = arr.length -1; i > 1; i--) {   // i > 1 passt

                for (int k = 0; k < i; k++) {
                    if (arr[k] > arr[k +1]) {
                        int temp = arr[k +1];
                        arr[k +1] = arr[k];
                        arr[k] = temp;
                    }
                }
            }
            t--;
        }
        long timeOfBubble = System.currentTimeMillis() - time2;

        // -----------------------------------------------  selection sort
        t = tries;
        long time3 = System.currentTimeMillis();
        while (t > 0) {
            int[] arr = new int[size];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = r.nextInt(randomMax);
            }

            for (int i = 0; i < arr.length -1; i++) {
                int indexOfMin = i;

                for (int k = i +1; k < arr.length; k++) {   //  search min in (from arr[i] to arr[arr.length] )
                    if (arr[k] < arr[indexOfMin]) {
                        indexOfMin = k;
                    }
                }

                if (arr[i] != arr[indexOfMin]) {
                    int temp = arr[i];
                    arr[i] = arr[indexOfMin];
                    arr[indexOfMin] = temp;
                }
            }
            t--;
        }
        long timeOfSelection = System.currentTimeMillis() - time3;

        System.out.printf("For array size = %d in tries = %d%n insertion:  %d ms%n bubble:     %d ms%n selection:  %d ms",
                size, tries, timeOfSelection, timeOfBubble, timeOfInsertion);
    }
}
