package org.kenny.algorithms.sorting.selectionSort.generic;

public class SelectionSort {

    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i ; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
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
//        Integer[] arr = new Integer[]{6, 4, 2, 5, 8, 1, 3, 7};
//        SelectionSort.sort(arr);
//        for (int i : arr) {
//            System.out.print(i + " ");
//        }

        int n = 10000;
        Integer[] array = ArrayGenerator.generateRandomArray(n, n);

//        long startTime = System.nanoTime();
//        SelectionSort.sort(array);
//        long endTime = System.nanoTime();
//        double time = (endTime - startTime) / 1000000000.0;
//
//        if (!SortingHelper.isSorted(array)) {
//            throw new RuntimeException("Sorted array is not sorted");
//        }
//        System.out.println(time + " s");

        /**
         *
         */
        SortingHelper.sortTest("SelectionSort", array);

        int[] dataSize = {10000, 100000};
        for (int i : dataSize) {
            Integer[] randomArray = ArrayGenerator.generateRandomArray(i, i);
            SortingHelper.sortTest("SelectionSort", randomArray);
        }

    }
}
