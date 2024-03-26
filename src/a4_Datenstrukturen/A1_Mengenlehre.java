package a4_Datenstrukturen;
import java.util.*;
public class A1_Mengenlehre {
//    Berechne möglichst effizient die Vereinigungsmenge von A ∪ B ∪ C sowie alle möglichen Schnittmengen und Differenzmengen der drei Zahlenmengen. Du kannst davon ausgehen, dass alle Mengen gleich groß sind.
//    Verwende dazu die bereits vorhandene Klasse "HashSet" und deren Methoden. Du sollst die Logik, wie sich z.B. eine Vereinigungsmenge bildet NICHT selbst programmieren. Die Klasse HashSet kann das schon.
//    Gestalte deine Methoden so, dass sie zur Berechnung der Ergebnismenge den selben return Typ haben wie die Parameter. Dadurch können die Methodenaufrufe beliebig oft geschachtelt werden.
//    z.B.: getUnionList(a, getIntersectionList(b,c)); // das sollte funktionieren und heißt A ∪ (B ∩ C)

    //  Hashsets
    public static void main(String[] args) {
        HashSet<Integer> A = new HashSet<>(Arrays.asList(1, 2, 3)),
                B = new HashSet<>(Arrays.asList(3, 5, 7)),
                C = new HashSet<>(Arrays.asList(5, 7, 9));

        System.out.println( getUnion (A, getUnion(B, C)) + " (expected: [1, 2, 3, 5, 7, 9])");
        System.out.println( getDifference (A, getDifference(B, C)) + " (expected: [1, 2])");
        System.out.println(getIntersection (A, B) + " (expected: [3])");
        System.out.println(getIntersection (A, getIntersection(B, C)) + " (expected: [])");
        System.out.println(getDifference (A, getIntersection(B, C)) + " (expected: [1, 2, 3])");
    }

    //   "2d" Hashset (Hashmap mit Hashsets)
    /*
    public static void main(String[] args) {

        int[][] mainArr = {{1,3,5}, {3,5,7}, {5,7,9}};
        Map<Character, HashSet<Integer>> numbersSet = new HashMap<>();
        char setName = 'A';

        for (var arr : mainArr) {
            HashSet<Integer> set = new HashSet<>();
            for (var num : arr) {
                set.add(num);
            }
            numbersSet.put(setName++, set);
        }

        for (var entry : numbersSet.entrySet()) {
            //System.out.println("Set " + entry.getKey() + ": " + entry.getValue());  // show sets
        }

        System.out.println(getUnion(numbersSet.get('A'), getUnion(numbersSet.get('B'), numbersSet.get('C'))) + " (expected: [1, 3, 5, 7, 9])");
        System.out.println(getDifference(numbersSet.get('A'), getDifference(numbersSet.get('B'), numbersSet.get('C'))) + " (expected: [1, 5])");
        System.out.println(getIntersection(numbersSet.get('A'), numbersSet.get('B')) + " (expected: [3, 5])");
        System.out.println(getIntersection(numbersSet.get('A'), getIntersection(numbersSet.get('B'), numbersSet.get('C'))) + " (expected: [5])");
        System.out.println(getDifference(numbersSet.get('A'), getIntersection(numbersSet.get('B'), numbersSet.get('C'))) + " (expected: [1, 3])");
    }
    */

    // METHODEN
    //getUnion  A ∪ B ---> union // x in A or x in B
    static Set<Integer> getUnion(Set<Integer> set1, Set<Integer> set2){
        Set<Integer> set = new HashSet<>(set1);  //copy set1
        set.addAll(set2);
        return set;
    }

    //getIntersection  B ∩ C ---> intersection // x in B and x in C
    static Set<Integer> getIntersection(Set<Integer> set1, Set<Integer> set2){
        Set<Integer> set = new HashSet<>();
        for (int i : set1) {
            if (set2.contains(i)) set.add(i);
        }
        /*Iterator<Integer> itr = set1.iterator();
        while(itr.hasNext()){
            int next = itr.next();
            if (set2.contains(next)) set.add(next);
        }*/
        return set;
    }

    //getDifference  A \ B ---> // x in A and x not in B
    static Set<Integer> getDifference(Set<Integer> set1, Set<Integer> set2){
        Set<Integer> set = new HashSet<>();
        for (int i : set1) {
            if (! set2.contains(i)) set.add(i);
        }

        return set;
    }
}
