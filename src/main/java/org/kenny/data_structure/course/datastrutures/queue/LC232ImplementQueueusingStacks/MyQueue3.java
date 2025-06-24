package org.kenny.data_structure.course.datastrutures.queue.LC232ImplementQueueusingStacks;

import java.util.Stack;

public class MyQueue3 {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    int front;

    public MyQueue3() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /**
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * Just pushes to stack1 and possibly updates front
     */
    public void push(int x) {
        if (stack1.isEmpty()) {
            front = x;
        }
        stack1.push(x);
    }

    /**
     * Time Complexity: Amortized O(1), Worst-case O(n)
     * Space Complexity: O(n)
     * 
     * Algorithm:
     * 1. If stack2 is not empty, pop from stack2 (O(1))
     * 2. If stack2 is empty, move all elements from stack1 to stack2 (O(n)), then pop
     * 3. Each element is moved at most once from stack1 to stack2, so amortized O(1)
     */
    public int pop() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        }

        while (stack1.size() > 1) {
            stack2.push(stack1.pop());
        }

        return stack1.pop();
    }

    /**
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * Returns the top of stack2 if not empty, otherwise returns front
     */
    public int peek() {
        if (!stack2.isEmpty()) {
            return stack2.peek();
        }
        return front;
    }

    /**
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * Checks if both stacks are empty
     */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    // Simple test for MyQueue3
    public static void main(String[] args) {
        MyQueue3 queue = new MyQueue3();
        System.out.println("Push 1"); queue.push(1);
        System.out.println("Push 2"); queue.push(2);
        System.out.println("Push 3"); queue.push(3);
        System.out.println("Peek: " + queue.peek()); // 1
        System.out.println("Pop: " + queue.pop());   // 1
        System.out.println("Peek: " + queue.peek()); // 2
        System.out.println("empty: " + queue.empty()); // false
        System.out.println("Pop: " + queue.pop());   // 2
        System.out.println("Pop: " + queue.pop());   // 3
        System.out.println("empty: " + queue.empty()); // true
    }
}
