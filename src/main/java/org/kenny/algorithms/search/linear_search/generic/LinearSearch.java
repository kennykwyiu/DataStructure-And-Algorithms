package org.kenny.algorithms.search.linear_search.generic;

public class LinearSearch {

    public static <E> int search (E[] array, E target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Integer[] data = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(LinearSearch.search(data, 10));
    }
}
