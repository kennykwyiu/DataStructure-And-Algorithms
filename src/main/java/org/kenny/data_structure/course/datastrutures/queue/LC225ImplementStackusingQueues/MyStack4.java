package org.kenny.data_structure.course.datastrutures.queue.LC225ImplementStackusingQueues;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack4 {
    private Queue<Integer> queue;

    public MyStack4() {
        queue = new LinkedList<>();
    }

    /**
     * Time Complexity: O(n) where n is the number of elements in the stack
     * Space Complexity: O(1) - no additional space needed
     * 
     * Algorithm:
     * 1. Add the new element to the end of the queue
     * 2. Rotate the queue by moving n-1 elements from front to back
     * 3. This places the new element at the front (top of stack)
     * 
     * Queue rotation approach:
     * - After adding new element, queue size becomes n
     * - Move n-1 elements from front to back
     * - New element ends up at the front (top of stack)
     * - Total operations: n-1 moves = O(n)
     * 
     * Note: This is similar to MyStack3 but uses rotation instead of creating a new queue
     * Advantage: No additional space needed (O(1) space complexity)
     * Disadvantage: Still O(n) time complexity for push operations
     */
    public void push(int x) {
        queue.add(x);
        for (int i = 1; i < queue.size(); i++) {
            queue.add(queue.remove());
        }
    }

    /**
     * Time Complexity: O(1) - OPTIMAL!
     * Space Complexity: O(1)
     * 
     * Algorithm:
     * Simply remove and return the first element from the queue
     * Since push() maintains stack order through rotation, the first element is always the top of stack
     * 
     * This is the key advantage of MyStack4 over MyStack and MyStack2
     * Same performance as MyStack3 for pop() operations
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
     * Since push() maintains stack order through rotation, the first element is always the top of stack
     * 
     * This is the key advantage of MyStack4 over MyStack and MyStack2
     * Same performance as MyStack3 for top() operations
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
