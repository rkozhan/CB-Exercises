package a4_Datenstrukturen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A3_ListeSortieren {
    public static void main(String[] args) {
        Integer[] arr = {14, 17, 3, 12, 9, 11, 6, 2};
        List<Integer> numList = new ArrayList<Integer>(Arrays.asList(arr));

        System.out.println(splitList(numList));
    }
    static List<Integer> splitList(List<Integer> list) {
        // ========== Aufteilung
        if (list.size() > 1) {
            list = mergeList(
                    splitList(list.subList(0, list.size()/2)),
                    splitList(list.subList(list.size()/2, list.size()))
            );
            /*
            List<Integer> left = new ArrayList<Integer>();
            List<Integer> right = new ArrayList<Integer>();
            int i = 0;

            for (i = 0; i < list.size(); i++) {
                if (i < list.size() / 2)  left.add(list.get(i));
                else right.add(list.get(i));
            }
            left = splitList(left);  // split to list.size() == 1
            right = splitList(right);

            // ============ Sortieren und Zusammenführen
            list = mergeList(left, right);  //sort and merge
            */
        }
        return list;
    }

    //  sort & merge
    static List<Integer> mergeList(List<Integer> left, List<Integer> right) {
        List<Integer> numList = new ArrayList<Integer>();
        int l = 0, r = 0; //Inkremente

        for (int i = 0; i < left.size() + right.size(); i++) {
            if (l < left.size() && r < right.size()) {
                numList.add(left.get(l) < right.get(r) ? left.get(l++) : right.get(r++));
            } else if (l < left.size()) {
                numList.add(left.get(l++));
            } else numList.add(right.get(r++));
        }
        return numList;
    }
}
