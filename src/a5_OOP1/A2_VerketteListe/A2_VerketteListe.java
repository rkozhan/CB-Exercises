package a5_OOP1.A2_VerketteListe;

public class A2_VerketteListe {
    public static void main(String[] args) {
        NodeList fruits = new NodeList();
        System.out.println(fruits.size());
        fruits.add("apple");
        System.out.println(fruits.size());
        fruits.add("banana");
        System.out.println(fruits);

        fruits.add(0, "mango");
        System.out.println(fruits);

        fruits.add(2, "kiwi");
        System.out.println(fruits);

        fruits.add(33,"orange");
        System.out.println(fruits);


        System.out.println(fruits);
        System.out.println(fruits.size());

        //System.out.println(fruits.get(2));

        fruits.remove(4);
        System.out.println(fruits);

    }
}
