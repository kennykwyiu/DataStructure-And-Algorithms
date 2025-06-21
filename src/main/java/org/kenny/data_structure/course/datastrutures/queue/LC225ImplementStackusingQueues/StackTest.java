package org.kenny.data_structure.course.datastrutures.queue.LC225ImplementStackusingQueues;

public class StackTest {
    public static void main(String[] args) {
        System.out.println("=== Testing MyStack (Original Implementation) ===");
        testMyStack();
        
        System.out.println("\n=== Testing MyStack2 (Improved Implementation) ===");
        testMyStack2();
        
        System.out.println("\n=== Performance Comparison ===");
        performanceComparison();
    }
    
    public static void testMyStack() {
        MyStack stack = new MyStack();
        
        System.out.println("Initial empty state: " + stack.empty());
        
        // Push operations
        System.out.println("\n--- Push Operations ---");
        stack.push(1);
        System.out.println("Pushed: 1, Top: " + stack.top() + ", Empty: " + stack.empty());
        
        stack.push(2);
        System.out.println("Pushed: 2, Top: " + stack.top() + ", Empty: " + stack.empty());
        
        stack.push(3);
        System.out.println("Pushed: 3, Top: " + stack.top() + ", Empty: " + stack.empty());
        
        // Pop operations
        System.out.println("\n--- Pop Operations ---");
        System.out.println("Popped: " + stack.pop() + ", Top: " + stack.top() + ", Empty: " + stack.empty());
        System.out.println("Popped: " + stack.pop() + ", Top: " + stack.top() + ", Empty: " + stack.empty());
        System.out.println("Popped: " + stack.pop() + ", Empty: " + stack.empty());
        
        // Test with more elements
        System.out.println("\n--- Testing with more elements ---");
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        
        System.out.println("Stack: 10->20->30->40 (top)");
        System.out.println("Top: " + stack.top());
        System.out.println("Popped: " + stack.pop() + ", New top: " + stack.top());
        System.out.println("Popped: " + stack.pop() + ", New top: " + stack.top());
    }
    
    public static void testMyStack2() {
        MyStack2 stack = new MyStack2();
        
        System.out.println("Initial empty state: " + stack.empty());
        
        // Push operations
        System.out.println("\n--- Push Operations ---");
        stack.push(1);
        System.out.println("Pushed: 1, Top: " + stack.top() + ", Empty: " + stack.empty());
        
        stack.push(2);
        System.out.println("Pushed: 2, Top: " + stack.top() + ", Empty: " + stack.empty());
        
        stack.push(3);
        System.out.println("Pushed: 3, Top: " + stack.top() + ", Empty: " + stack.empty());
        
        // Pop operations
        System.out.println("\n--- Pop Operations ---");
        System.out.println("Popped: " + stack.pop() + ", Top: " + stack.top() + ", Empty: " + stack.empty());
        System.out.println("Popped: " + stack.pop() + ", Top: " + stack.top() + ", Empty: " + stack.empty());
        System.out.println("Popped: " + stack.pop() + ", Empty: " + stack.empty());
        
        // Test with more elements
        System.out.println("\n--- Testing with more elements ---");
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        
        System.out.println("Stack: 10->20->30->40 (top)");
        System.out.println("Top: " + stack.top());
        System.out.println("Popped: " + stack.pop() + ", New top: " + stack.top());
        System.out.println("Popped: " + stack.pop() + ", New top: " + stack.top());
    }
    
    public static void performanceComparison() {
        System.out.println("--- Performance Comparison ---");
        System.out.println("MyStack.top()  - Time Complexity: O(n)");
        System.out.println("MyStack2.top() - Time Complexity: O(1) - IMPROVED!");
        System.out.println();
        System.out.println("Both implementations have:");
        System.out.println("- push(): O(1)");
        System.out.println("- pop(): O(n)");
        System.out.println("- empty(): O(1)");
        System.out.println();
        System.out.println("Key Difference:");
        System.out.println("- MyStack2 maintains a 'top' variable for O(1) top() calls");
        System.out.println("- MyStack calls pop() and push() for top(), making it O(n)");
    }
} 