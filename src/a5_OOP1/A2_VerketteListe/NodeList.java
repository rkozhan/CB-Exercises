package a5_OOP1.A2_VerketteListe;
import java.util.LinkedList;
public class NodeList {
    static Node first;
    public boolean add(String value) {
        Node newNode = new Node(value);
        if (first == null) {
            first = newNode;
        } else {
            Node last = first;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }
        return true;
    }
    public  void add(int index, String value) {
        Node newNode = new Node(value);
        int currentIndex = 0;
        Node current = first;
        if (index <= 0) {
            newNode.next = first;
            first = newNode;
        } else {
            /*
            while (current.next != null) {
                currentIndex++;
                if (currentIndex == index) break;
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
             */

            Node prev = index < this.size() ? this.get(index-1) : this.get(this.size()-1);
            newNode.next = prev.next;
            prev.next = newNode;
        }
    }

    public int size() {
        if (first != null) {
            int size = 1;
            Node current = first;
            while (current.next != null) {
                current = current.next;
                size++;
            }
            return size;
        }
        return 0;
    }

    public Node get(int index) {
        if (index < 0 || index >= this.size()) return null;

        int currentIndex = 0;
        Node current = first;
        while (current != null) {
            if (currentIndex == index) return current;
            current = current.next;
            currentIndex++;
        }
        return current;
    }

    public Node remove(int index) {
        Node current = null;
        if (first != null && index < this.size() && index >= 0) {
            //current = first;
            Node prev = null;
            if (index == 0) {
                first = first.next;          //what to do, to delete Node completely?
                return prev;
            }
            /*
            int i = 0;
            while (i != index) {
                prev = current;
                current = current.next;
                i++;
            }
            prev.next = current.next;
            */
            prev = this.get(index-1);
            current = prev.next;
            prev.next = prev.next.next;
        }
        return current;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Node current = first;
        while (current != null) {
            result.append(current.toString()).append("\n");
            current = current.next;
        }
        return result.toString();
    }



}


/*Aufgabe 2: verkettete Liste
Wie auch Arrays ist die verkettete Liste eine lineare Datenstruktur, allerdings besteht die verkettete
 Liste aus einzelnen Elementen (Nodes) die durch Zeiger miteinander verbunden sind.

Um die Liste zu implementieren benötigst du 2 Klassen. Die Klasse Node hat ein Attribut value (z.B.: vom
Typ String) und einen Zeiger vom Typ Node auf das nächste Element. Die zweite Klasse ist die Liste selbst.
 Hier implementieren wir alle Funktionen die unsere Liste haben soll.

Folgene Funktionalität sollte unsere Liste zumindest haben:
boolean add(E e)
void    add(int index, E element)
int     size()
E       get(int index)
E       remove(int index)
*/