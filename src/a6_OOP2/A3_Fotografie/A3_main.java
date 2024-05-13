package a6_OOP2.A3_Fotografie;
public class A3_main {
    public static void main(String[] args) {
        Lens lens1 = new Lens(24, 70);
        Lens lens2 = new Lens(70, 200);
        Lens lens3 = null;
        try {
            lens3 = new Lens(200, 70); // Invalid parameters
        } catch (IllegalArgumentException e) {
            System.err.println("Error: Min cannot be greater than Max for a lens!");
        }

        Camera nikon = new Camera("Nikon", 54.8, 4, true);
        Camera canon = new Camera("Canon", 30, 3.5, true, lens1);
        Camera sony = new Camera("Sony", 35, 3.8, false, lens1);

        sony.setLens(lens3);

        System.out.println(nikon);
        System.out.println(canon);
        System.out.println(sony);

        System.out.println("Instanzen von Camera: " + Camera.getCounter());
        System.out.println("Instanzen von Lens: " +Lens.getCounter());
    }


}
