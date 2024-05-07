package a5_OOP1.A3_DoubleListe;
public class A3_main {
    public static void main(String[] args) {
        DList fruits = new DList();
        fruits.add(new Dnode("kiwi"));

        fruits.add(0,new Dnode("apple"));
        fruits.add(0,new Dnode("banana"));

        fruits.add(new Dnode("mango"));

        System.out.println(fruits.remove(3));

        System.out.println(fruits.toString());
        System.out.println(fruits.toStringReverse());
        System.out.println(fruits.size());

        fruits.add(3, new Dnode("papaya"));
        System.out.println(fruits.toString());
        System.out.println(fruits.toStringReverse());
        System.out.println(fruits.remove(4));
        System.out.println(fruits.size());

    }
}