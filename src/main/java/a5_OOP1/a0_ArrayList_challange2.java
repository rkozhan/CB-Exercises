package main.java.a5_OOP1;
import java.util.ArrayList;
import java.util.Random;

public class a0_ArrayList_challange2 {

    public static void main(String[] args) {
        Random r = new Random();
        ArrayList<Integer> trees = new ArrayList <>();
        long sum = 0;
        int maxId = 0, max = 0;

        for (int i=0; i < 100; i++) {
            int num = r.nextInt(Integer.MAX_VALUE);
            trees.add(num);
            sum += num;
            if (max < num) {
                max = num;
                maxId = i;
            }
        }
        System.out.println(sum);
        System.out.println(maxId);
    }

    /*
    public static void main(String[] args) {
        ArrayList<Tree> trees = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            int leaves = getRandomLeaves();
            Tree tree = new Tree(i + 1, leaves);
            trees.add(tree);
        }
        System.out.println("Gesamtzahl der Blätter: " + calculateTotalLeaves(trees));

        System.out.println("Baum mit den meisten Blättern:");
        System.out.println(findTreeWithMostLeaves(trees));
    }

    private static int getRandomLeaves() {
        Random r = new Random();
        return r.nextInt(Integer.MAX_VALUE);
    }

    private static long calculateTotalLeaves(ArrayList<Tree> trees) {
        long total = 0;
        for (Tree tree : trees) {
            total += tree.getLeaves();
        }
        return total;
    }

    private static Tree findTreeWithMostLeaves(ArrayList<Tree> trees) {
        Tree maxLeavesTree = null;
        int maxLeaves = 0;
        for (Tree tree : trees) {
            if (tree.getLeaves() > maxLeaves) {
                maxLeaves = tree.getLeaves();
                maxLeavesTree = tree;
            }
        }
        return maxLeavesTree;
    }
}

// Klasse für den Baum
class Tree {
    private int id, leaves;
    public Tree(int id, int leaves) {
        this.id = id;
        this.leaves = leaves;
    }

    public int getId() {
        return id;
    }
    public int getLeaves() {
        return leaves;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Blätter: " + leaves;
    }
    */

}

/*
ArrayList Challenge 2
1. Erstelle eine Klasse Namens „Tree“, welche einen int „leaves“ und einen int „id“ hat
   Erstelle 100 „Tree“ – Objekte mit zufälliger Anzahl an „leaves“ und einzigertiger „id“
   und speichere sie in einer Liste.
2. Gib aus, wie viele Blätter insgesamt vorhanden sind.
3. Gib aus, welcher Baum die meisten Blätter hat
*/