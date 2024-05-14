package main.java.a6_OOP2.A3_Fotografie;
import java.text.MessageFormat;
public class Lens {
    private int minFocalLength, maxFocalLength;
    private static int counter = 0;
    public Lens(int minFocalLength, int maxFocalLength) {
        //checkLens(minFocalLength, maxFocalLength);
        setMaxFocalLength(maxFocalLength);
        setMinFocalLength(minFocalLength);
        counter++;
    }


 //SETTERS
    public void setMinFocalLength(int minFocalLength) {
        checkLens(minFocalLength, maxFocalLength);
        this.minFocalLength = minFocalLength;
    }
    public void setMaxFocalLength(int maxFocalLength) {
        checkLens(minFocalLength, maxFocalLength);
        this.maxFocalLength = maxFocalLength;
    }

    //CHECK FOCAL LENGTH
    private void checkLens(int min, int max) {
        if (max <= min) throw new IllegalArgumentException("MAX focal length should be greater than MIN");
    }


//GETTERS
    public int getMinFocalLength() {
        return minFocalLength;
    }
    public int getMaxFocalLength() {
        return maxFocalLength;
    }
    public static int getCounter() {
        return counter;
    }

    @Override
    public String toString() {
        return MessageFormat.format("Objektiv: {0}-{1}", minFocalLength, maxFocalLength);
    }
}
