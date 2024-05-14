package main.java.a6_OOP2.A3_Fotografie;

import java.text.MessageFormat;

public class Camera {
    private String brand;
    private double megaPixels, displaySize;
    private boolean colored;
    private Lens lens = null;
    private static int counter = 0;

    public Camera(String brand, double megaPixels, double displaySize, boolean colored, Lens lens) {
        try {
            setLens(lens);
            setBrand(brand);
            setMegaPixels(megaPixels);
            setDisplaySize(displaySize);
            setColored(colored);
            counter++;
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating camera: " + e.getMessage());
        }
    }
    public Camera(String brand, double megaPixels, double displaySize, boolean colored) {      // Ohne Lens
        try {
            setBrand(brand);
            setMegaPixels(megaPixels);
            setDisplaySize(displaySize);
            setColored(colored);
            counter++;
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating camera: " + e.getMessage());
        }
    }

// SETTERS
    public void setBrand(String brand) {
        //if (brand == null || brand.isEmpty()) throw new IllegalArgumentException("'Brand' cannot be null or empty.");
        this.brand = brand;
    }
    public void setMegaPixels(double megaPixels) {
        //if (megaPixels <= 0) throw new IllegalArgumentException("'Megapixels' should be more then 0.");
        this.megaPixels = megaPixels;
    }
    public void setDisplaySize(double displaySize) {
        //if (displaySize < 1 || displaySize > 10) throw new IllegalArgumentException("'Display size' should be more between 1 and 10.");
        this.displaySize = displaySize;
    }
    public void setColored(boolean colored) {
        this.colored = colored;
    }
    public void setLens(Lens lens) {
        this.lens = lens;
    }
// GETTERS
    public String getBrand() {
        return brand;
    }
    public double getMegaPixels() {
        return megaPixels;
    }
    public double getDisplaySize() {
        return displaySize;
    }
    public boolean isColored() {
        return colored;
    }
    public static int getCounter() {
        return counter;
    }
    public Lens getLens() {
        return lens;
    }
    @Override
    public String toString() {
        String colored = this.colored ? "Farb" : "Schwarzweiß";
        String lens = (this.lens == null ) ? "Ohne Objektiv" : String.valueOf(this.lens);
        return MessageFormat.format("{0}kamera {1}, {2} MP, Display Größe {3} Zoll, Objektiv: {4}.", colored, brand, megaPixels, displaySize, lens);
    }
}
