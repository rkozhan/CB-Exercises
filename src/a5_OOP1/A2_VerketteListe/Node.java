package a5_OOP1.A2_VerketteListe;

import java.text.MessageFormat;

class Node {
    public String value;
    public Node next;

    public Node(String value) {
        this.value = value;
        this.next = null;
    }
    /*
    public void setNext(Node next) {
        this.next = next;
    }
    public Node getNext() {
        return next;
    }
     */

    @Override
    public String toString() {
        return value;
    }

}
