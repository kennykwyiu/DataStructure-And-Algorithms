package org.kenny.data_structure.course.datastrutures.queue.LC225ImplementStackusingQueues;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack3 {
    private Queue<Integer> queue;

    public MyStack3() {
        queue = new LinkedList<>();
    }

    /**
     * Time Complexity: O(n) where n is the number of elements in the stack
     * Space Complexity: O(n) for the temporary queue
     * 
     * Algorithm:
     * 1. Create a new temporary queue
     * 2. Add the new element to the front of temp queue
     * 3. Move all existing elements from main queue to temp queue
     * 4. Replace main queue with temp queue
     * 
     * This approach maintains stack order in the queue:
     * - New elements are always at the front (top of stack)
     * - Old elements are pushed to the back
     * - Total operations: n moves = O(n)
     * 
     * Note: This is the most efficient approach for all operations
     */
    public void push(int x) {
        Queue<Integer> temp = new LinkedList<>();
        temp.add(x);
        while (!queue.isEmpty()) {
            temp.add(queue.remove());
        }
        queue = temp;
    }

    /**
     * Time Complexity: O(1) - OPTIMAL!
     * Space Complexity: O(1)
     * 
     * Algorithm:
     * Simply remove and return the first element from the queue
     * Since push() maintains stack order, the first element is always the top of stack
     * 
     * This is the key advantage of MyStack3 over MyStack and MyStack2
     */
    public int pop() {
        return queue.remove();
    }

    /**
     * Time Complexity: O(1) - OPTIMAL!
     * Space Complexity: O(1)
     * 
     * Algorithm:
     * Simply peek at the first element in the queue
     * Since push() maintains stack order, the first element is always the top of stack
     * 
     * This is the key advantage of MyStack3 over MyStack and MyStack2
     */
    public int top() {
        return queue.peek();
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
