package org.kenny.algorithms.sorting.selectionSort.generic;

import org.kenny.algorithms.sorting.insertionSort.InsertionSort;

public class SortingHelper {
    private SortingHelper() {
    }

    public static <T extends Comparable<T>> boolean isSorted(T[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1].compareTo(array[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static <T extends Comparable<T>> void sortTest(String sortName, T[] array) {
        long startTime = System.nanoTime();
        if ("SelectionSort".equals(sortName)) {
            SelectionSort.sort(array);
        } else if ("InsertionSort".equals(sortName)) {
            InsertionSort.sort(array);
        } else if ("OptimizedInsertionSort".equals(sortName)) {
            InsertionSort.optimizedSort(array);
        }
        long endTime = System.nanoTime();
        double time = (endTime - startTime) / 1000000000.0;

        if (!SortingHelper.isSorted(array)) {
            throw new RuntimeException(sortName + " is failed");
        }
        System.out.printf("%s, n = %d : %f%n",
                sortName,
                array.length,
                time);
    }
}
