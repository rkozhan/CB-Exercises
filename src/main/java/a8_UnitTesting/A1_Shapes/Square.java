package main.java.a8_UnitTesting.A1_Shapes;
public class Square extends Rectangle {
    public Square(String color, boolean isFilled, double side) {
        super(color, isFilled, side, side);
        setSide(side);
    }

    public double getSide() {
        return getWidth();
    }
    public void setSide(double side) {
        setWidth(side);
        setLength(side);
    }

    @Override
    public void setLength  (double side) {
        super.setWidth(side);
        super.setLength(side);
    }
    @Override
    public void setWidth  (double side) {
        super.setWidth(side);
        super.setLength(side);
    }
}
