package test.java.a6_OOP2.A1_Stack;
import main.java.a6_OOP2.A1_Stack.Stack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StackTest {
    private Stack stack;
    @BeforeEach
    void setUp() {
        stack = new Stack();
    }

    @Test
    void sizeTest() {
        stack.push(1);
        stack.push(2);
        //expected Value is 2
        assertEquals(2, stack.size());
    }

    @Test
    void peekTest() {
        //expected Value is -1
        assertEquals(-1, stack.peek());

        stack.push(1);
        stack.push(2);
        stack.push(3);
        //expected Value is 1
        assertEquals(1, stack.peek());
    }

    @Test
    void popTest() {
        //expected Value is -1
        assertEquals(-1, stack.pop());

        stack.push(1);
        stack.push(2);
        stack.push(3);
        //expected Value is 1
        assertEquals(1, stack.pop());
    }

    @Test
    void popTestMultipleElements() {
        //expected Value is {}
        int[] expected = {};
        assertArrayEquals(expected, stack.pop(0));

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        //expected Value is {}
        int[] expected0 = {};
        assertArrayEquals(expected0, stack.pop(0));

        //expected Value is {1,2}
        int[] expected1 = {1,2,3};
        assertArrayEquals(expected1, stack.pop(3));

        //expected Value is {4}
        int[] expected2 = {4};
        assertArrayEquals(expected2, stack.pop(1));
    }

    @Test
    void exceptionPopTest () {
        //When we call the Method with -1, we expect that an IllegalArgumentException is thrown
        assertThrows(IllegalArgumentException.class, () -> stack.pop(-1));

        stack.push(1);
        stack.push(2);

        //When we call the Method with 3, we expect that an IllegalArgumentException is thrown
        assertThrows(IllegalArgumentException.class, () -> stack.pop(3));
    }

    @Test
    void pushTest() {
        //expected Value is 0
        assertEquals(0, stack.size());
        stack.push(1);
        stack.push(2);
        //expected Value is 6
        assertEquals(2, stack.size());
    }
}
