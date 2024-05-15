package main.java.a8_UnitTesting.A1_Shapes;
public class Rectangle extends Shape {
    private double width, length;
    public Rectangle(String color, boolean isFilled, double width, double length) {
        super(color, isFilled);
        setWidth(width);
        setLength(length);
    }
    // SETTERS
    public void setWidth(double width) {
        //if (width <= 0) throw new IllegalArgumentException("width must be positive number");
        check(width, "width");
        this.width = width;
    }
    public void setLength(double length) {
        //if (length <= 0) throw new IllegalArgumentException("length must be positive number");
        check(length, "length");
        this.length = length;
    }
    // GETTERS
    public double getWidth() {
        return width;
    }
    public double getLength() {
        return length;
    }

    @Override
    public double getArea() {
        return width * length;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + length);
    }
}
