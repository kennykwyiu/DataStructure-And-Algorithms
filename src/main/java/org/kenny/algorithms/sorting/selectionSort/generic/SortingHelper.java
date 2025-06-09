package org.kenny.algorithms.sorting.selectionSort.generic;

public class SortingHelper {
    private SortingHelper() {
    }

    public static <T extends Comparable<T>> boolean isSort(T[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1].compareTo(array[i]) > 0) {
                return false;
            }
        }
        return true;
    }
}
