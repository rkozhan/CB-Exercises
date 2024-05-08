package a6_OOP2.A1_Stack;

import java.util.Arrays;

public class A1_main {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.pop();
        stack.peek();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack.peek());

        System.out.println(stack);
        System.out.println(Arrays.toString(stack.pop(-2)));

        System.out.println(stack.size());
        System.out.println(stack);
        System.out.println(Arrays.toString(stack.pop(5)));
    }
}

/*
Aufgabe: Stack
Implementiere einen IntStack! Ein Stack ist ein Stapel, der immer die Dinge zuerst abarbeitet, die er zuletzt bekommen hat nach dem Last in first out Prinzip. Die Klasse Stack sollte folgende Methoden haben:

void push(int newElement)
fügt ein neues Element oben in den Stack ein
int size()
gibt die Anzahl der Elemente im Stack zurück
int pop()
gibt das letzte Elemente des Stacks zurück und entfernt dieses vom Stack
int peek()
gibt das letzte Elemente des Stacks zurück ohne den Stack zu modifizieren
int[] pop(int n)
gibt die letzten n Elemente des Stacks zurück und entfernt diese vom Stack
Wird auf einen leeren Stack pop() oder peek() aufgerufen sollte eine Fehlermeldung ausgegeben werden.

Leg in der Main Methode einen Stack an und schreib ein paar Beispiel-Verwendungen.

Tipp: Für die Implementation kannst du deine doppelt Verkettete Liste aus dem letzten Modul verwenden!!! Lege ein Klassen-Attribut von deiner Liste an NICHT von der Node!!!!
 */