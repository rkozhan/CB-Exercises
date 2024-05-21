package main.java.a5_OOP1.A2_VerketteListe;
class Node<T> {
    T value;
    Node<T> next;
    Node(T value) {
        this.value = value;
        this.next = null;
    }
    @Override
    public String toString() {
        return String.valueOf(value);
    }
}

/*
- The class declaration is now NodeList<T> to indicate that it is a generic class with a type parameter T.
- Node<T> is used instead of Node throughout the class to specify that the Node objects hold values of type T.
- The add and add(int index, T value) methods now accept values of type T.
- The remove method returns a Node<T> instead of just Node.
*/