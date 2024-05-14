package test.java.a6_OOP2.A2_Queue;
import main.java.a6_OOP2.A2_Queue.Queue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
    private Queue queue;
    @BeforeEach
    void setUp() {
        queue = new Queue();
    }

    @Test
    void enqueueTest() {  // enqueue() fügt ein neues Element hinten in die Schlange ein
        //expected Value is 0
        assertEquals(0, queue.size());

        queue.enqueue(1);
        queue.enqueue(2);
        //expected Value is 2
        assertEquals(2, queue.size());


    }

    @Test
    void dequeueTest() {
        //expected Value is -1
        assertEquals(-1, queue.dequeue());

        queue.enqueue(1);
        queue.enqueue(2);
        //expected Value is 1
        assertEquals(1, queue.dequeue());
    }

    @Test
    void dequeueTestMultipleElements() {  // dequeue() gibt die ersten n Elemente der Schlange zurück und entfernt diese daraus
        //expected Value is {}
        int[] expected = {};
        assertArrayEquals(expected, queue.dequeue(0));

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        //expected Value is {}
        int[] expected0 = {};
        assertArrayEquals(expected0, queue.dequeue(0));

        //expected Value is {1,2}
        int[] expected1 = {1,2};
        assertArrayEquals(expected1, queue.dequeue(2));
    }

    @Test
    void exceptionDequeueTest () {
        //When we call the Method with -1, we expect that an IllegalArgumentException is thrown
        assertThrows(IllegalArgumentException.class, () -> queue.dequeue(-1));

        queue.enqueue(1);
        queue.enqueue(2);

        //When we call the Method with 3, we expect that an IllegalArgumentException is thrown
        assertThrows(IllegalArgumentException.class, () -> queue.dequeue(3));
    }

    @Test
    void sizeTest() {
        //expected Value is 0
        assertEquals(0, queue.size());

        queue.enqueue(1);
        queue.enqueue(2);
        //expected Value is 2
        assertEquals(2, queue.size());
    }
}
