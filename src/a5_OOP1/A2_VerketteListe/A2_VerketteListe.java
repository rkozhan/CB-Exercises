package a5_OOP1.A2_VerketteListe;

public class A2_VerketteListe {
    public static void main(String[] args) {
        NodeList<Integer> intList = new NodeList<>();

        intList.add(new Node<> (3));
        intList.add(new Node<> (4));

        intList.add(0, new Node<> (1));
        intList.add(1, new Node<> (2));
        System.out.println(intList);

        intList.add(3,new Node<> (5));
        System.out.println(intList);

        System.out.println(intList.get(2));
        System.out.println(intList.size());

        System.out.println(intList.remove(1));
        System.out.println(intList);
        System.out.println(intList.size());
    }
}



/*
Aufgabe 2: verkettete Liste
Wie auch Arrays ist die verkettete Liste eine lineare Datenstruktur,
allerdings besteht die verkettete Liste aus einzelnen Elementen (Nodes) die durch Zeiger miteinander verbunden sind.

Um die Liste zu implementieren benötigst du 2 Klassen.
- Die Klasse Node (im Bild A, B, ..) hat ein Attribut value (z.B.: vom Typ String)
und einen Zeiger vom Typ Node auf das nächste Element.
- Die zweite Klasse ist die Liste selbst. Hier implementieren wir alle Funktionen die unsere Liste haben soll.

Folgene Funktionalität sollte unsere Liste zumindest haben:
(Siehe auch Java List Interface: https://docs.oracle.com/javase/8/docs/api/java/util/List.html)

boolean add(E e)
void    add(int index, E element)
int     size()
E       get(int index)
E       remove(int index)

Zusätzlich:

String  toString() # Return a string representing the values of the list properly formated
Für diese Aufgabe benötigst du KEINE anderen Datenstrukturen (Arrays, ArrayList, etc.).
Hier ein einfaches Beispiel für die Grundstruktur: https://www.geeksforgeeks.org/linked-list-set-1-introduction/

Bonus: Du kannst deine Liste mit Generics(https://www.geeksforgeeks.org/generics-in-java/) implementieren, sodass der Typ des gespeicherte Wertes value, beim erstellen der Liste dynamisch angegeben werden kann.
*/