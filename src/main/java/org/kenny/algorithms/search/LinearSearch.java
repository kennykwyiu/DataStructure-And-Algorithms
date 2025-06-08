package org.kenny.algorithms.search;

public class LinearSearch {

    private LinearSearch() {}

    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 7, 8, 9, 10};
        System.out.println(linearSearch(arr, 10));

        System.out.println(linearSearch(arr, 11));
    }
}
