package a6_OOP2.A2_Queue;

import java.util.Arrays;

public class A2_main {
    public static void main(String[] args) {
        Queue queue = new Queue();
        System.out.println(queue.dequeue());
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        System.out.println("size: "+ queue.size());
        System.out.println(queue);

        System.out.println(queue.dequeue());

        System.out.println(Arrays.toString(queue.dequeue(2)));

        System.out.println(Arrays.toString(queue.dequeue(4)));
    }
}
