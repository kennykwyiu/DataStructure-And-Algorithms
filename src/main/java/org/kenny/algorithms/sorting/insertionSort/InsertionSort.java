package org.kenny.algorithms.sorting.insertionSort;

import org.kenny.algorithms.sorting.selectionSort.generic.ArrayGenerator;
import org.kenny.algorithms.sorting.selectionSort.generic.SortingHelper;

import java.util.Arrays;

public class InsertionSort {
    private InsertionSort() {
    }

    public static <T extends Comparable<T>> void sort(T[] array) {
        for (int i = 0; i < array.length; i++) {
//            for (int j = i; j - 1 >= 0; j--) {
//                if (array[j].compareTo(array[j - 1]) < 0) {
//                    swap(array, j, j - 1);
//                } else {
//                    break;
//                }
//            }

            for (int j = i; j - 1 >= 0 && array[j].compareTo(array[j - 1]) < 0; j--) {
                swap(array, j, j - 1);
            }
        }
    }

    public static <T extends Comparable<T>> void optimizedSort(T[] array) {
        for (int i = 0; i < array.length; i++) {
            T temp = array[i];
            int j;
            for (j = i; j - 1 >= 0 && temp.compareTo(array[j - 1]) < 0; j--) {
                array[j] = array[j - 1];
            }
            array[j] = temp;
        }
    }

    private static <E> void swap(E[] arr, int i, int j) {
        if (i != j) {
            E temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] dataSize = {10000, 100000};
        for (int i : dataSize) {
//            Integer[] randomArray = ArrayGenerator.generateRandomArray(i, i);
//            Integer[] randomArray2 = Arrays.copyOf(randomArray, randomArray.length);
//            SortingHelper.sortTest("InsertionSort", randomArray);
//            SortingHelper.sortTest("OptimizedInsertionSort", randomArray2);

            System.out.println("Random Array: ");

            Integer[] array = ArrayGenerator.generateRandomArray(i, i);
            Integer[] array2 = Arrays.copyOf(array, array.length);
            SortingHelper.sortTest("SelectionSort", array);
            SortingHelper.sortTest("OptimizedInsertionSort", array2);

            System.out.println();

            System.out.println("Ordered Array: ");
            array = ArrayGenerator.generateOrderedArray(i);
            array2 = Arrays.copyOf(array, array.length);

            SortingHelper.sortTest("SelectionSort", array);
            SortingHelper.sortTest("OptimizedInsertionSort", array2);
            System.out.println();
        }
    }
}
