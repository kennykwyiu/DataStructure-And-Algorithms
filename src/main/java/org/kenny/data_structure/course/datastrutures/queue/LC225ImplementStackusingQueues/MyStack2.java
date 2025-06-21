package org.kenny.data_structure.course.datastrutures.queue.LC225ImplementStackusingQueues;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack2 {
    private Queue<Integer> queue;
    private int top;

    public MyStack2() {
        queue = new LinkedList<>();
    }

    /**
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * 
     * Algorithm:
     * 1. Add element to the end of the queue
     * 2. Update the top variable to track the latest element
     * Both operations are constant time
     */
    public void push(int x) {
        queue.add(x);
        top = x;
    }

    /**
     * Time Complexity: O(n) where n is the number of elements in the stack
     * Space Complexity: O(n) for the temporary queue
     * 
     * Algorithm:
     * 1. Move n-1 elements from main queue to temp queue
     * 2. Update top variable during the process to track the new top
     * 3. Remove the last element (top of stack)
     * 4. Replace main queue with temp queue
     * Total operations: n-1 moves = O(n)
     * 
     * Note: This is still O(n) but maintains the top variable for O(1) top() calls
     */
    public int pop() {
        Queue<Integer> temp = new LinkedList<>();
        while (queue.size() > 1) {
            top = queue.peek();
            temp.add(queue.remove());
        }
        int ret = queue.peek();
        queue = temp;
        return ret;
    }

    /**
     * Time Complexity: O(1) - IMPROVED from O(n) in MyStack1
     * Space Complexity: O(1)
     * 
     * Algorithm:
     * Simply returns the stored top variable
     * This is the key improvement over MyStack1 where top() was O(n)
     */
    public int top() {
        return top;
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
