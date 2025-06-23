package org.kenny.data_structure.course.datastrutures.queue.LC232ImplementQueueusingStacks;

import java.util.Stack;

public class MyQueue {
    private Stack<Integer> stack;

    public MyQueue() {
        stack = new Stack<>();
    }

    /**
     * Time Complexity: O(n) where n is the number of elements in the queue
     * Space Complexity: O(n) for the temporary stack
     * 
     * Algorithm:
     * 1. Move all elements from main stack to tempStack
     * 2. Push the new element onto the main stack
     * 3. Move all elements back from tempStack to main stack
     * This maintains queue order in the stack
     */
    public void push(int x) {
        Stack<Integer> tempStack = new Stack<>();

        while (!stack.isEmpty()) {
            tempStack.push(stack.pop());
        }
        stack.push(x);

        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }

    /**
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * Simply pops the top element from the stack (front of the queue)
     */
    public int pop() {
        return stack.pop();
    }

    /**
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * Simply peeks at the top element of the stack (front of the queue)
     */
    public int peek() {
        return stack.peek();
    }

    /**
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * Checks if the stack is empty
     */
    public boolean empty() {
        return stack.isEmpty();
    }

    // Simple test for MyQueue
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        System.out.println("Push 1"); queue.push(1);
        System.out.println("Push 2"); queue.push(2);
        System.out.println("Push 3"); queue.push(3);
        System.out.println("Peek: " + queue.peek()); // 1
        System.out.println("Pop: " + queue.pop());   // 1
        System.out.println("Peek: " + queue.peek()); // 2
        System.out.println("Empty: " + queue.empty()); // false
        System.out.println("Pop: " + queue.pop());   // 2
        System.out.println("Pop: " + queue.pop());   // 3
        System.out.println("Empty: " + queue.empty()); // true
    }
}
