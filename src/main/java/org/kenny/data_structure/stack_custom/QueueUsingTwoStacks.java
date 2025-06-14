package org.kenny.data_structure.stack_custom;

import java.util.Scanner;
import java.util.Stack;

public class QueueUsingTwoStacks {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        QueueUsingTwoStacks queueUsingTwoStacks = new QueueUsingTwoStacks();
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();

        for (int i = 0; i < q; i++) {
            int queryType = scanner.nextInt();
            if (queryType == 1) {
                int value = scanner.nextInt();
                queueUsingTwoStacks.enqueue(value);
            } else if (queryType == 2) {
                queueUsingTwoStacks.dequeue();
            } else if (queryType == 3) {
                queueUsingTwoStacks.print();
            }
        }

        scanner.close();

    }

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void enqueue(int x) {
        stack1.push(x);
    }

    public int dequeue() {
        shiftStacks();
        return stack2.pop();
    }

    public void print() {
        System.out.println(peek());
    }

    private void shiftStacks() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
    }

    private int peek() {
        shiftStacks();
        return stack2.peek();
    }

}
