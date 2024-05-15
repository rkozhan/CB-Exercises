package main.java.a8_UnitTesting.A1_Shapes;

import java.util.ArrayList;
import java.util.List;

public class A1_main {
    public static void main(String[] args) {
        List<Shape> allShapes= new ArrayList<>();

        allShapes.add(new Circle( "red", true, 1));
        allShapes.add(new Circle( "green", false, 2));

        allShapes.add(new Rectangle( "green", false, 5, 10));
        allShapes.add(new Rectangle( "blue", true, 10, 30));

        allShapes.add(new Square( "pink", false, 10));
        allShapes.add(new Square( "grey", true, 1));

        System.out.printf("%10s %15s %10s%n", "shape", "perimeter", "area");
        for(Shape shape : allShapes) {
            String className =shape.getClass().toString().replaceAll("^.*\\.", "");
            System.out.printf("%10s %15.2f %10.2f%n", className, shape.getPerimeter(), shape.getArea());
        }

        //check  IllegalArgumentException
        //Shape c = new Circle( "red", true, -1);
        //Shape s = new Square( "blue", true, -1);
        //Shape r = new Rectangle( "blue", true, 8, -30);

        // problem: setWidth or setLength for Square -> override!
        Shape shape = new Square( "blue", true, 1);
        ((Square) shape).setWidth(2);
        System.out.println(shape.getArea());
        //((Square) shape).setWidth(-2);
    }
}

/*
Aufgabe: Shapes
Wir implementieren ein Programm, in dem wir auf einer Fläche Formen repräsentieren können.

Eine Form(Shape) ist eine abstrakte Klasse und hat einige Eigenschaften:

color beinhaltet den Farbcode für die Darstellung
isFilled ist ein boolscher Wert der ausdrückt ob die Form ausgefüllt wird oder nicht.
Jede Form hat außerdem zwei Methoden

public abstract double getArea() gibt die Fläche einer Form zurück
public abstract double getPerimeter() gibt den Umfang einer Form zurück
Wir implementieren einige konkrete Formen.
 */