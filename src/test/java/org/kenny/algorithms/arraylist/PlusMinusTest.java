package org.kenny.algorithms.arraylist;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PlusMinusTest {

    @Test
    public void testPlusMinusCase1() {
        List<Integer> arr = Arrays.asList(-4, 3, -9, 0, 4, 1);
        PlusMinus.plusMinus(arr);
        BigDecimal expectedPositive = new BigDecimal("0.500000");
        BigDecimal expectedNegative = new BigDecimal("0.333333");
        BigDecimal expectedZero = new BigDecimal("0.166667");
        assertEquals(expectedPositive, PlusMinus.positiveBigDecimal);
        assertEquals(expectedNegative, PlusMinus.negativeBigDecimal);
        assertEquals(expectedZero, PlusMinus.zeroBigDecimal);
    }

    @Test
    public void testPlusMinusCase2() {
        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5);
        PlusMinus.plusMinus(arr);
        BigDecimal expectedPositive = new BigDecimal("1.000000");
        BigDecimal expectedNegative = new BigDecimal("0.000000");
        BigDecimal expectedZero = new BigDecimal("0.000000");
        assertEquals(expectedPositive, PlusMinus.positiveBigDecimal);
        assertEquals(expectedNegative, PlusMinus.negativeBigDecimal);
        assertEquals(expectedZero, PlusMinus.zeroBigDecimal);
    }

    @Test
    public void testPlusMinusCase3() {
        List<Integer> arr = Arrays.asList(-1, -2, -3, -4, -5);
        PlusMinus.plusMinus(arr);
        BigDecimal expectedPositive = new BigDecimal("0.000000");
        BigDecimal expectedNegative = new BigDecimal("1.000000");
        BigDecimal expectedZero = new BigDecimal("0.000000");
        assertEquals(expectedPositive, PlusMinus.positiveBigDecimal);
        assertEquals(expectedNegative, PlusMinus.negativeBigDecimal);
        assertEquals(expectedZero, PlusMinus.zeroBigDecimal);
    }

    @Test
    public void testPlusMinusCase4() {
        List<Integer> arr = Arrays.asList(0, 0, 0, 0, 0);
        PlusMinus.plusMinus(arr);
        BigDecimal expectedPositive = new BigDecimal("0.000000");
        BigDecimal expectedNegative = new BigDecimal("0.000000");
        BigDecimal expectedZero = new BigDecimal("1.000000");
        assertEquals(expectedPositive, PlusMinus.positiveBigDecimal);
        assertEquals(expectedNegative, PlusMinus.negativeBigDecimal);
        assertEquals(expectedZero, PlusMinus.zeroBigDecimal);
    }
}
