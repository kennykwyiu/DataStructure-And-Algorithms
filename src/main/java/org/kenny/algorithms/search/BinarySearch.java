package org.kenny.algorithms.search;

public class BinarySearch {

    public static int binarySearch(int[] array, int target) {

        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == array[mid]) {
                return mid;
            } else if (target < array[mid]) {
                right = mid - 1;

            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 21, 33, 45 ,45, 61, 71, 72, 73};
        int target = 33;

        int result = binarySearch(arr, target);
        System.out.println(result);
    }
}

