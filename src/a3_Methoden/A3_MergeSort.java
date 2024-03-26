package a3_Methoden;
import java.util.Arrays;
public class A3_MergeSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(splitArr(new int[]{14, 17, 3, 12, 9, 11, 6, 2})));
        System.out.println(Arrays.toString(mergeSort(new int[]{14, 17, 3, 12, 9, 11, 6, 2})));
    }
    static int[] splitArr(int[] arr) {
        if (arr.length > 1) {
            /*
            int[] left = Arrays.copyOfRange(arr, 0, arr.length / 2);
            int[] right = Arrays.copyOfRange(arr, arr.length / 2, arr.length);

            left = splitArr(left);  // split to arr.length == 1
            right = splitArr(right);

            arr = mergeArr(left, right);  //merge and sort
             */
            arr = mergeArr(
                    splitArr(Arrays.copyOfRange(arr, 0, arr.length / 2)),
                    splitArr(Arrays.copyOfRange(arr, arr.length / 2, arr.length))
            );
            System.out.println(Arrays.toString(arr));
        }
        return arr;
    }
    static int[] mergeArr(int[] left, int[] right) {
        int[] arr = new int[left.length  + right.length];
        int l = 0, r = 0;

        for (int i = 0; i < arr.length; i++) {
            if (l < left.length && r < right.length) {
                arr[i] = left[l] < right[r] ? left[l++] : right[r++];
            } else if (l < left.length) {
                arr[i] = left[l++];
            } else arr[i] = right[r++];
        }
        return arr;
    }


    static int[] mergeSort (int[] arr) {  //// ---  SPLIT & MERGE

        if (arr.length > 1) {

            //int[] left = new int[arr.length / 2];
            //int[] right = new int[arr.length - arr.length / 2];

            //for (int i = 0; i < arr.length; i++) {
            //    if (i < left.length) left[i] = arr[i];
            //    else right[i - left.length] = arr[i];
            //}

            int[] left = Arrays.copyOfRange(arr, 0, arr.length / 2);
            int[] right = Arrays.copyOfRange(arr, arr.length / 2, arr.length);

            left = mergeSort(left);
            right = mergeSort(right);

            // ---  MERGE and SORT without extra function    ( left + right -> to arr )

            int a = 0, l = 0, r = 0;

            while (l < left.length && r < right.length) {
                arr[a++] = left[l] < right[r] ? left[l++] : right[r++];
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
