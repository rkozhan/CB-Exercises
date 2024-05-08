package a5_OOP1.A3_DoubleListe;

class Dnode<T> {
    T value;
    Dnode<T> next, prev;
    Dnode (T value) {
        this.value = value;
        this.prev = null;
        this.next = null;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
