package a5_OOP1.A3_DoubleListe;
public class DList<T> {
    Dnode<T> first, last;
    int length = 0;
    int size() {
        return length;
    }

    Dnode<T> get(int index) {
        if (index < 0 || index >= this.size()) return null;
        Dnode<T> currentNode = first;
        if (index < this.size()/2) {
            int currentIndex = 0;
            while (currentIndex != index) {
                currentNode = currentNode.next;
                currentIndex++;
            }
        } else {
            int currentIndex = this.size()-1;
            currentNode = last;
            while (currentIndex != index) {
                currentNode = currentNode.prev;
                currentIndex--;
            }
        }
        return currentNode;
    }

    boolean add(Dnode<T> newNode) {
        if (first == null) {
            first = last = newNode;
        } else {
            newNode.prev = last;
            last.next = newNode;
            last = newNode;
        }
        length++;
        return true;
    }

    void add(int index, Dnode<T> newNode) {
        if (index < 0 || index > size()) {
            System.out.println(index + " is out of range");
        } else {
            if (index == this.size()) {             // to last place (also if empty)
                this.add(newNode);
            } else {
                if (index == 0) {                   // add to first place
                    newNode.next = first;
                    first.prev = newNode;
                    first = newNode;
                } else {                            // add to other place
                    Dnode<T> currentNode = this.get(index);
                    currentNode.prev.next = newNode;
                    newNode.prev = currentNode.prev;
                    currentNode.prev = newNode;
                    newNode.next = currentNode;
                }
                length++;
            }
        }
    }

    Dnode<T> remove(int index) {
        Dnode<T> currentNode = this.get(index);
        if (currentNode == null) {
            System.out.println(index + " is out of range");
        } else {
            if (this.size() == 1) {
                first = last = null;                    // now is empty
            } else {
                if (index == 0) {                       // delete first
                    first = first.next;
                    first.prev = null;
                } else if (index == this.size()-1) {    // delete last
                    last = last.prev;
                    last.next = null;
                } else {                                // delete other
                    currentNode.prev.next = currentNode.next;
                    currentNode.next.prev = currentNode.prev;
                }
            }
            length--;
        }
        return currentNode;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Dnode<T> current = first;
        while (current != null) {
            result.append(current).append(" --> ");
            current = current.next;
        }
        result.append("null");
        return result.toString();
    }

    public String toStringReverse() {
        StringBuilder result = new StringBuilder();
        Dnode<T> current = last;
        while (current != null) {
            result.append(current).append(" --> ");
            current = current.prev;
        }
        result.append("null");
        return result.toString();
    }
}




// WITHOUT GENERICS
/*
public class DList {
    static Dnode first, last;
    int length = 0;
    int size() {
        return length;
    }

    Dnode get(int index) {
        if (index < 0 || index >= this.size()) return null;
        Dnode currentNode = first;
        if (index < this.size()/2) {
            int currentIndex = 0;
            while (currentIndex != index) {
                currentNode = currentNode.next;
                currentIndex++;
            }
        } else {
            int currentIndex = this.size()-1;
            currentNode = last;
            while (currentIndex != index) {
                currentNode = currentNode.prev;
                currentIndex--;
            }
        }
        return currentNode;
    }

    boolean add(Dnode newNode) {
        if (first == null) {
            first = last = newNode;
        } else {
            newNode.prev = last;
            last.next = newNode;
            last = newNode;
        }
        length++;
        return true;
    }

    void add(int index, Dnode newNode) {
        if (index < 0 || index > size()) {
            System.out.println(index + " is out of range");
        } else {
            if (index == this.size()) {             // to last place (also if empty)
                this.add(newNode);
            } else {
                if (index == 0) {                   // add to first place
                    newNode.next = first;
                    first.prev = newNode;
                    first = newNode;
                } else {                            // add to other place
                    Dnode currentNode = this.get(index);
                    currentNode.prev.next = newNode;
                    newNode.prev = currentNode.prev;
                    currentNode.prev = newNode;
                    newNode.next = currentNode;
                }
                length++;
            }
        }
    }

    Dnode remove(int index) {
        Dnode currentNode = this.get(index);
        if (currentNode == null) {
            System.out.println(index + " is out of range");
        } else {
            if (this.size() == 1) {
                first = last = null;                    // now is empty
            } else {
                if (index == 0) {                       // delete first
                    first = first.next;
                    first.prev = null;
                } else if (index == this.size()-1) {    // delete last
                    last = last.prev;
                    last.next = null;
                } else {                                // delete other
                    currentNode.prev.next = currentNode.next;
                    currentNode.next.prev = currentNode.prev;
                }
            }
            length--;
        }
        return currentNode;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Dnode current = first;
        while (current != null) {
            result.append(current).append(" --> ");
            current = current.next;
        }
        result.append("null");
        return result.toString();
    }

    public String toStringReverse() {
        StringBuilder result = new StringBuilder();
        Dnode current = last;
        while (current != null) {
            result.append(current).append(" --> ");
            current = current.prev;
        }
        result.append("null");
        return result.toString();
    }
}

 */