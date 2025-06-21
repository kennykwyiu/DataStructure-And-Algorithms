package org.kenny.data_structure.course.datastrutures.queue.LC225ImplementStackusingQueues;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    private Queue<Integer> queue;
    public MyStack() {
        queue = new LinkedList<>();
    }
    public void push(int x) {
        queue.add(x);
    }

    public int pop() {
        Queue<Integer> temp = new LinkedList<>();
        while (queue.size() > 1) {
            temp.add(queue.remove());
        }
        int ret = queue.remove();

        queue = temp;
        return ret;
    }

    public int top() {
        int ret = pop();
        push(ret);
        return ret;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
