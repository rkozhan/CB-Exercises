package a5_OOP1.A3_DoubleListe;

public class Dnode<T> {
    public T value;
    public Dnode<T> next, prev;
    public Dnode(T value) {
        this.value = value;
        this.prev = null;
        this.next = null;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
