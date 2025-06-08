package org.kenny.algorithms.sorting.selectionSort.generic;

public class SelectionSort {

    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
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
        Integer[] arr = new Integer[]{6, 4, 2, 5, 8, 1, 3, 7};
        SelectionSort.sort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
