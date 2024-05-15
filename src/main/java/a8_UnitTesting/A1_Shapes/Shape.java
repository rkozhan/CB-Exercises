package main.java.a8_UnitTesting.A1_Shapes;
public  abstract class Shape {
    private String color;
    private boolean isFilled;

    public Shape(String color, boolean isFilled) {
        setColor(color);
        setFilled(isFilled);
    }

    public void setColor(String color) {
        this.color = color;
    }
    public void setFilled(boolean isFilled) {
        this.isFilled = isFilled;
    }

    protected void check(double d, String str) {
        if (d <= 0) throw new IllegalArgumentException(str + " must be positive number");
    }

    public String getColor() {
        return color;
    }
    public boolean isFilled() {
        return isFilled;
    }

    public abstract double getArea();

    public abstract double getPerimeter();

}
