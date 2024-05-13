package a6_OOP2.A1_Stack;
import a5_OOP1.A3_DoubleListe.DList;
import a5_OOP1.A3_DoubleListe.Dnode;

public class Stack {
    private final DList<Integer> stackList = new DList<>();
    public void push(int newElement) {  // fügt ein neues Element oben in den Stack ein
        Dnode<Integer> newNode = new Dnode<>(newElement);
        stackList.add(newNode); //add(newNode, size())
    }
    public int size() {                // gibt die Anzahl der Elemente im Stack zurück
        return stackList.size();
    }
    public int peek() {         // gibt das letzte Elemente des Stacks zurück ohne den Stack zu modifizieren
        return isEmpty() ? -1 : stackList.get(0).value;
    }
    public int pop() {          //  gibt das letzte Elemente des Stacks zurück und entfernt dieses vom Stack
        return isEmpty() ? -1 : stackList.remove(0).value;
    }
    public int[] pop(int n) {// gibt die letzten n Elemente des Stacks zurück und entfernt diese vom Stack
        if (n < 0 || n > size()) System.err.println(n < 0 ? "Error: n < 0"
                                                            : "only "+ size() +" elements in a Stack");
        n = Math.min(n, size());
        if (n > 0) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = pop();
            }
            return arr;
        }
        return new int[0];
    }

    private boolean isEmpty() {     // Wird auf einen leeren Stack pop() oder peek() aufgerufen sollte eine Fehlermeldung ausgegeben werden.
        if (size() == 0) {
            System.err.println("Stack is empty.");
            return true;
        }
        return false;
    }
    @Override
    public String toString() {
        return stackList.toStringReverse();
    }
}
