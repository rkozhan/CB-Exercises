package a5_OOP1.A2_VerketteListe;
import java.util.LinkedList;
public class NodeList<T> {
    Node<T> first;
    int length = 0;
    int size() {
        return length;
    }

    Node<T> get(int index) {
        if (index < 0 || index >= this.size()) return null;  // out of range

        int currentIndex = 0;
        Node<T> currentNode = first;
        while (currentIndex != index) {
            currentNode = currentNode.next;
            currentIndex++;
        }
        return currentNode;
    }

    boolean add(Node<T> newNode) {
        if (first == null) {  // if empty
            first = newNode;
        } else {
            get(size()-1).next = newNode;   // add link to last node
        }
        length++;
        return true;
    }

    void add(int index, Node<T> newNode) {
        if (index < 0 || index > size()) {
            System.out.println(index + " is out of range");
        } else {
            if (index == size()) {
                add(newNode);
            } else {
                if (index == 0) {
                    newNode.next = first;
                    first = newNode;
                } else {
                    Node<T> prevNode = get(index-1);
                    newNode.next = prevNode.next;
                    prevNode.next = newNode;
                }
                length++;
            }
        }
    }

    Node<T> remove(int index) {
        Node<T> currentNode = this.get(index);
        if (currentNode == null) {
            System.out.println((index + " is out of range"));
        } else {
            if (index == 0) {                // delete first
                currentNode = first;
                first = first.next;          //how to delete node completely from a memory?
            } else {
                Node<T> prevNode = this.get(index - 1);
                currentNode = prevNode.next;
                prevNode.next = currentNode.next;
            }
            length--;
        }
        return currentNode;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Node<T> currentNode = first;
        while (currentNode != null) {
            result.append(currentNode.toString()).append(" --> ");
            currentNode = currentNode.next;
        }
        result.append("null");
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