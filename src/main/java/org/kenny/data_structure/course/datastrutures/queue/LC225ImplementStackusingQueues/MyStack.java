package org.kenny.data_structure.course.datastrutures.queue.LC225ImplementStackusingQueues;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    private Queue<Integer> queue;
    
    public MyStack() {
        queue = new LinkedList<>();
    }
    
    /**
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * Simply adds an element to the end of the queue
     */
    public void push(int x) {
        queue.add(x);
    }

    /**
     * Time Complexity: O(n) where n is the number of elements in the stack
     * Space Complexity: O(n) for the temporary queue
     * 
     * Algorithm:
     * 1. Move n-1 elements from main queue to temp queue
     * 2. Remove the last element (top of stack)
     * 3. Move all elements back to main queue
     * Total operations: 2(n-1) = O(n)
     */
    public int pop() {
        Queue<Integer> temp = new LinkedList<>();
        while (queue.size() > 1) {
            temp.add(queue.remove());
        }
        int ret = queue.remove();

        queue = temp;
        return ret;
    }

    /**
     * Time Complexity: O(n) where n is the number of elements in the stack
     * Space Complexity: O(n) for the temporary queue used in pop()
     * 
     * Algorithm:
     * 1. Call pop() to get the top element: O(n)
     * 2. Push the element back: O(1)
     * Total: O(n) + O(1) = O(n)
     */
    public int top() {
        int ret = pop();
        push(ret);
        return ret;
    }

    /**
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * Simple check if queue is empty
     */
    public boolean empty() {
        return queue.isEmpty();
    }
}
