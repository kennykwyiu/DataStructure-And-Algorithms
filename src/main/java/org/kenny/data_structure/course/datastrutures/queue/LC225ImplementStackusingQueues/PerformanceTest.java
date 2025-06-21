package org.kenny.data_structure.course.datastrutures.queue.LC225ImplementStackusingQueues;

public class PerformanceTest {
    public static void main(String[] args) {
        System.out.println("=== Performance Comparison: MyStack vs MyStack2 vs MyStack3 ===\n");
        
        MyStack stack1 = new MyStack();
        MyStack2 stack2 = new MyStack2();
        MyStack3 stack3 = new MyStack3();
        
        // Quick benchmark - top() performance
        System.out.println("=== Top() Performance Benchmark ===\n");
        StackPerformanceTester.quickBenchmark(stack1, stack2, "MyStack", "MyStack2");
        System.out.println();
        StackPerformanceTester.quickBenchmark(stack2, stack3, "MyStack2", "MyStack3");
        System.out.println();
        StackPerformanceTester.quickBenchmark(stack1, stack3, "MyStack", "MyStack3");
        
        System.out.println("\n" + "=".repeat(60) + "\n");
        
        // Pop performance test
        StackPerformanceTester.testPopPerformance(stack1, stack2, stack3, "MyStack", "MyStack2", "MyStack3", 1000, 100);
        
        System.out.println("\n" + "=".repeat(60) + "\n");
        
        // Comprehensive comparison of all three
        StackPerformanceTester.compareAllImplementations(stack1, stack2, stack3, "MyStack", "MyStack2", "MyStack3");
        
        System.out.println("\n" + "=".repeat(60) + "\n");
        
        // Individual stack tests
        StackPerformanceTester.testSingleStack(stack1, "MyStack");
        System.out.println();
        StackPerformanceTester.testSingleStack(stack2, "MyStack2");
        System.out.println();
        StackPerformanceTester.testSingleStack(stack3, "MyStack3");
        
        System.out.println("\n" + "=".repeat(60) + "\n");
        
        detailedAnalysis();
    }
    
    public static void detailedAnalysis() {
        System.out.println("=== Detailed Analysis ===");
        System.out.println("MyStack.top() complexity: O(n)");
        System.out.println("- Calls pop() which moves n-1 elements");
        System.out.println("- Then calls push() to restore the element");
        System.out.println("- Total: 2(n-1) operations");
        System.out.println();
        System.out.println("MyStack2.top() complexity: O(1)");
        System.out.println("- Simply returns the stored 'top' variable");
        System.out.println("- No element movement required");
        System.out.println("- Total: 1 operation");
        System.out.println();
        System.out.println("MyStack3.top() complexity: O(1) - OPTIMAL!");
        System.out.println("- Simply peeks at the first element in the queue");
        System.out.println("- No element movement required");
        System.out.println("- Total: 1 operation");
        System.out.println();
        System.out.println("MyStack3.pop() complexity: O(1) - OPTIMAL!");
        System.out.println("- Simply removes the first element from the queue");
        System.out.println("- No element movement required");
        System.out.println("- Total: 1 operation");
        System.out.println();
        System.out.println("Expected behavior:");
        System.out.println("- MyStack3 should be fastest for both top() and pop() operations");
        System.out.println("- MyStack2 should be faster than MyStack for top() operations");
        System.out.println("- MyStack3 sacrifices push() performance (O(n)) for optimal read performance");
    }
} 