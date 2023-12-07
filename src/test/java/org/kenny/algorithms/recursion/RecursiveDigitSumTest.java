package org.kenny.algorithms.recursion;
import org.junit.Assert;
import org.junit.Test;

public class RecursiveDigitSumTest {

    @Test
    public void testSuperDigit() {
        // Test case 1
        String n1 = "9876";
        int k1 = 4;
        int expected1 = 3;
        int result1 = RecursiveDigitSum.superDigit(n1, k1);
        Assert.assertEquals(expected1, result1);

        // Test case 2
        String n2 = "123";
        int k2 = 3;
        int expected2 = 9;
        int result2 = RecursiveDigitSum.superDigit(n2, k2);
        Assert.assertEquals(expected2, result2);

        // Test case 3
        String n3 = "999999999999999999999999999999";
        int k3 = 2;
        int expected3 = 9;
        int result3 = RecursiveDigitSum.superDigit(n3, k3);
        Assert.assertEquals(expected3, result3);

    }
}
