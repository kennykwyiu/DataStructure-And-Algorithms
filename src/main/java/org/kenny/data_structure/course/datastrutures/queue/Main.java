package org.kenny.data_structure.course.datastrutures.queue;

import java.util.ArrayDeque;
import java.util.Random;

public class Main {
    private  static double testQueue(Queue<Integer> queue, int operationCount) {

        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < operationCount; i++) {
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < operationCount; i++) {
            queue.dequeue();
        }
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int operationCount = 1000000;

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = testQueue(arrayQueue, operationCount);
        System.out.println("ArrayQueue: " + time1 + " seconds");

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time2 = testQueue(loopQueue, operationCount);
        System.out.println("LoopQueue: " + time2 + " seconds");

    }
}
