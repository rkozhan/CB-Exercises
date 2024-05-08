package a6_OOP2.A2_Queue;
import a5_OOP1.A3_DoubleListe.DList;
import a5_OOP1.A3_DoubleListe.Dnode;

public class Queue {
    private final DList<Integer> queueList = new DList<>();

    public void enqueue(int newElement) {   // fügt ein neues Element hinten in die Schlange ein
        Dnode<Integer> newNode = new Dnode<>(newElement);
        queueList.add(newNode);
    }
    int dequeue() { // gibt das erste Elemente der Schlange zurück und entfernt dieses daraus
        return isEmpty() ? -1 : queueList.remove(0).value;
    }
    int[] dequeue(int n) {  // gibt die ersten n Elemente der Schlange zurück und entfernt diese daraus
        if (n < 0 || n > size()) System.err.println(n < 0 ? "Error: n < 0"
                : "only "+ size() +" elements in a Stack");
        n = Math.min(n, size());
        if (n > 0) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = dequeue();
            }
            return arr;
        }
        return new int[0];
    }
    public int size() {                // gibt die Anzahl der Elemente im Stack zurück
        return queueList.size();
    }  // gibt die Anzahl der Elemente in der Queue zurück

    private boolean isEmpty() {     // Wird auf einen leeren Stack pop() oder peek() aufgerufen sollte eine Fehlermeldung ausgegeben werden.
        if (size() == 0) {
            System.err.println("Queue is empty.");
            return true;
        }
        return false;
    }
    @Override
    public String toString() {
        return queueList.toString();
    }
}
