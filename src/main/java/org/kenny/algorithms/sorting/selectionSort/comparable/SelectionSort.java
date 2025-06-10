package org.kenny.algorithms.sorting.selectionSort.comparable;

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
        Student[] students = {new Student("Alice", 98),
                new Student("Bobo", 100),
                new Student("Charles", 66)};
        SelectionSort.sort(students);
        for (Student student : students) {
            System.out.println(student + " ");
        }
        System.out.println();
    }
}
