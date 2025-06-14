package org.kenny.data_structure.queue;

public class Main {
    // ArrayQueue (ArrayDeque)
    // enqueue
    // dequeue
    // peek
    // isEmpty
    // isFull
    // [10, 20, 30, 40, 50]
    //   F              R
    // F = 0
    // R = 4
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
//        int front = queue.dequeue();
//        queue.enqueue(40);
//        queue.enqueue(50);
//        queue.enqueue(60);
//        queue.enqueue(70);
//        System.out.println(front);
//        System.out.println(queue);

    }
}
