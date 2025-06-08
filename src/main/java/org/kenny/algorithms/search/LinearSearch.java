package org.kenny.algorithms.search;

public class LinearSearch {

    private LinearSearch() {}

    public static int search(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 7, 8, 9, 10};
        System.out.println(LinearSearch.search(arr, 10));

        System.out.println(LinearSearch.search(arr, 11));
    }
}
