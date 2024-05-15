package main.java.a8_UnitTesting.A1_Shapes;
public class Circle extends Shape {
    private double radius;
    public Circle(String color, boolean isFilled, double radius) {
        super(color, isFilled);
        setRadius(radius);
    }
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        //if (radius <= 0) throw new IllegalArgumentException("Radius must be positive number");
        check(radius, "radius");
        this.radius = radius;
    }
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}
