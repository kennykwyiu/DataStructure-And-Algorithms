package org.kenny.data_structure.course.datastrutures.queue.LC232ImplementQueueusingStacks;

import java.util.Stack;

public class MyQueue2 {
    private Stack<Integer> stack;
    int front;

    public MyQueue2() {
        stack = new Stack<>();
    }

    /**
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * Just pushes to the stack and possibly updates front
     */
    public void push(int x) {
        if (isEmpty()) {
            front = x;
        }
        stack.push(x);
    }

    /**
     * Time Complexity: O(n) where n is the number of elements in the queue
     * Space Complexity: O(n) for the temporary stack
     * 
     * Algorithm:
     * 1. Move all but one element to a temporary stack, updating front
     * 2. Pop the last element (front of the queue)
     * 3. Restore the elements back to the main stack
     */
    public int pop() {
        Stack<Integer> tempStack = new Stack<>();
        while (stack.size() > 1) {
            front = stack.pop();
            tempStack.push(stack.pop());
        }
        int ret = stack.pop();

        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
        return ret;
    }

    /**
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * Returns the cached front value
     */
    public int peek() {
        return front;
    }

    /**
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * Checks if the stack is empty
     */
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    // Simple test for MyQueue2
    public static void main(String[] args) {
        MyQueue2 queue = new MyQueue2();
        System.out.println("Push 1"); queue.push(1);
        System.out.println("Push 2"); queue.push(2);
        System.out.println("Push 3"); queue.push(3);
        System.out.println("Peek: " + queue.peek()); // 1
        System.out.println("Pop: " + queue.pop());   // 1
        System.out.println("Peek: " + queue.peek()); // 2
        System.out.println("isEmpty: " + queue.isEmpty()); // false
        System.out.println("Pop: " + queue.pop());   // 2
        System.out.println("Pop: " + queue.pop());   // 3
        System.out.println("isEmpty: " + queue.isEmpty()); // true
    }
}
