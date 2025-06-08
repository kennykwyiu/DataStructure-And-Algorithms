package org.kenny.algorithms.search.linear_search.custom_class;

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
        Student[] students = {new Student("Alice"),
                new Student("Bobo"),
                new Student("Charles")};
        Student bobo = new Student("Bobo");
        Student charles = new Student("Charles");
        System.out.println(search(students, bobo));
        System.out.println(search(students, charles));
    }
}
