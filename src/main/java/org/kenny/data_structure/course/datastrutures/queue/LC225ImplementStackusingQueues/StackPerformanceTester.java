package org.kenny.data_structure.course.datastrutures.queue.LC225ImplementStackusingQueues;

/**
 * Utility class for testing stack performance with reusable static methods
 */
public class StackPerformanceTester {
    
    /**
     * Generic method to test any stack implementation
     * @param stackName Name of the stack implementation
     * @param stack The stack instance to test
     * @param size Size of the stack to test
     * @param iterations Number of top() calls to measure
     * @return Time taken in seconds
     */
    public static double testStackPerformance(String stackName, Object stack, int size, int iterations) {
        // Build the stack
        if (stack instanceof MyStack) {
            MyStack myStack = (MyStack) stack;
            for (int i = 0; i < size; i++) {
                myStack.push(i);
            }
            
            long startTime = System.nanoTime();
            for (int i = 0; i < iterations; i++) {
                myStack.top();
            }
            long endTime = System.nanoTime();
            return (endTime - startTime) / 1_000_000_000.0;
            
        } else if (stack instanceof MyStack2) {
            MyStack2 myStack2 = (MyStack2) stack;
            for (int i = 0; i < size; i++) {
                myStack2.push(i);
            }
            
            long startTime = System.nanoTime();
            for (int i = 0; i < iterations; i++) {
                myStack2.top();
            }
            long endTime = System.nanoTime();
            return (endTime - startTime) / 1_000_000_000.0;
            
        } else if (stack instanceof MyStack3) {
            MyStack3 myStack3 = (MyStack3) stack;
            for (int i = 0; i < size; i++) {
                myStack3.push(i);
            }
            
            long startTime = System.nanoTime();
            for (int i = 0; i < iterations; i++) {
                myStack3.top();
            }
            long endTime = System.nanoTime();
            return (endTime - startTime) / 1_000_000_000.0;
        }
        
        return 0.0;
    }
    
    /**
     * Generic method to compare performance between two stack implementations
     */
    public static void compareStackPerformance(String name1, Object stack1, String name2, Object stack2, int size, int iterations) {
        double time1 = testStackPerformance(name1, stack1, size, iterations);
        double time2 = testStackPerformance(name2, stack2, size, iterations);
        
        double improvement = time1 / time2;
        
        System.out.printf("%s.top() time: %.6f seconds\n", name1, time1);
        System.out.printf("%s.top() time: %.6f seconds\n", name2, time2);
        System.out.printf("Improvement: %.2fx faster\n", improvement);
        
        if (improvement > 10) {
            System.out.println("✅ " + name2 + " is significantly faster!");
        } else if (improvement > 2) {
            System.out.println("✅ " + name2 + " is noticeably faster!");
        } else {
            System.out.println("⚠️  Performance difference is minimal for this size");
        }
    }
    
    /**
     * Test multiple stack sizes with the generic method
     */
    public static void runComprehensiveTest(Object stack1, Object stack2, String name1, String name2) {
        System.out.println("=== Comprehensive Performance Test ===\n");
        
        int[] sizes = {100, 500, 1000, 5000, 10000};
        int iterations = 1000;
        
        for (int size : sizes) {
            System.out.println("Stack size: " + size + ", Iterations: " + iterations);
            compareStackPerformance(name1, stack1, name2, stack2, size, iterations);
            System.out.println();
        }
    }
    
    /**
     * Test a single stack implementation with multiple sizes
     */
    public static void testSingleStack(Object stack, String name) {
        System.out.println("=== Testing " + name + " ===\n");
        
        int[] sizes = {100, 500, 1000, 5000, 10000};
        int iterations = 1000;
        
        for (int size : sizes) {
            double time = testStackPerformance(name, stack, size, iterations);
            System.out.printf("%s (size %d): %.6f seconds\n", name, size, time);
        }
    }
    
    /**
     * Benchmark method for quick performance check
     */
    public static void quickBenchmark(Object stack1, Object stack2, String name1, String name2) {
        System.out.println("=== Quick Benchmark ===\n");
        compareStackPerformance(name1, stack1, name2, stack2, 1000, 1000);
    }
    
    /**
     * Stress test with large stack sizes
     */
    public static void stressTest(Object stack1, Object stack2, String name1, String name2) {
        System.out.println("=== Stress Test ===\n");
        
        int[] sizes = {10000, 20000, 50000};
        int iterations = 100;
        
        for (int size : sizes) {
            System.out.println("Stack size: " + size + ", Iterations: " + iterations);
            compareStackPerformance(name1, stack1, name2, stack2, size, iterations);
            System.out.println();
        }
    }
    
    /**
     * Test pop() performance for different stack implementations
     */
    public static void testPopPerformance(Object stack1, Object stack2, Object stack3, String name1, String name2, String name3, int size, int iterations) {
        System.out.println("=== Pop Performance Test (size: " + size + ", iterations: " + iterations + ") ===\n");
        
        // Test MyStack pop performance
        MyStack myStack = (MyStack) stack1;
        for (int i = 0; i < size; i++) {
            myStack.push(i);
        }
        
        long startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            myStack.pop();
            myStack.push(i); // Restore the element
        }
        long endTime = System.nanoTime();
        double time1 = (endTime - startTime) / 1_000_000_000.0;
        
        // Test MyStack2 pop performance
        MyStack2 myStack2 = (MyStack2) stack2;
        for (int i = 0; i < size; i++) {
            myStack2.push(i);
        }
        
        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            myStack2.pop();
            myStack2.push(i); // Restore the element
        }
        endTime = System.nanoTime();
        double time2 = (endTime - startTime) / 1_000_000_000.0;
        
        // Test MyStack3 pop performance
        MyStack3 myStack3 = (MyStack3) stack3;
        for (int i = 0; i < size; i++) {
            myStack3.push(i);
        }
        
        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            myStack3.pop();
            myStack3.push(i); // Restore the element
        }
        endTime = System.nanoTime();
        double time3 = (endTime - startTime) / 1_000_000_000.0;
        
        System.out.printf("%s.pop() time: %.6f seconds\n", name1, time1);
        System.out.printf("%s.pop() time: %.6f seconds\n", name2, time2);
        System.out.printf("%s.pop() time: %.6f seconds\n", name3, time3);
        
        double improvement1 = time1 / time3;
        double improvement2 = time2 / time3;
        
        System.out.printf("\n%s is %.2fx faster than %s\n", name3, improvement1, name1);
        System.out.printf("%s is %.2fx faster than %s\n", name3, improvement2, name2);
        
        if (improvement1 > 10) {
            System.out.println("✅ " + name3 + " pop() is significantly faster!");
        }
    }
    
    /**
     * Comprehensive comparison of all three stack implementations
     */
    public static void compareAllImplementations(Object stack1, Object stack2, Object stack3, String name1, String name2, String name3) {
        System.out.println("=== Comprehensive Comparison: All Three Implementations ===\n");
        
        int[] sizes = {100, 500, 1000, 2000};
        int iterations = 500;
        
        for (int size : sizes) {
            System.out.println("Stack size: " + size + ", Iterations: " + iterations);
            
            double time1 = testStackPerformance(name1, stack1, size, iterations);
            double time2 = testStackPerformance(name2, stack2, size, iterations);
            double time3 = testStackPerformance(name3, stack3, size, iterations);
            
            System.out.printf("%s.top(): %.6f seconds\n", name1, time1);
            System.out.printf("%s.top(): %.6f seconds\n", name2, time2);
            System.out.printf("%s.top(): %.6f seconds\n", name3, time3);
            
            double improvement1 = time1 / time3;
            double improvement2 = time2 / time3;
            
            System.out.printf("Improvement: %s is %.2fx faster than %s\n", name3, improvement1, name1);
            System.out.printf("Improvement: %s is %.2fx faster than %s\n", name3, improvement2, name2);
            System.out.println();
        }
    }
} 