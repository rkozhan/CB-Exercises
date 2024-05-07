package a5_OOP1.A3_DoubleListe;

class Dnode {
    String value;
    Dnode next, prev;
    Dnode (String value) {
        this.value = value;
        this.prev = null;
        this.next = null;
    }

    @Override
    public String toString() {
        return value;
    }
}
