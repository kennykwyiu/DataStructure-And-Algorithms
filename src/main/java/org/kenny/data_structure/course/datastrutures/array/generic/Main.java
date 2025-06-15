package org.kenny.data_structure.course.datastrutures.array.generic;


import org.kenny.algorithms.sorting.selectionSort.comparable.Student;

public class Main {
    public static void main(String[] args) {
//        Array<Integer> array = new Array<>(20);
//        for (int i = 0; i < 10; i++) {
//            array.addLast(i);
//        }
//        System.out.println(array);
//        array.add(1, 100);
//        System.out.println(array);
//
//        array.addFirst(-1);
//        System.out.println(array);
//
//        array.remove(2);
//        System.out.println(array);
//
//        array.removeElement(4);
//        System.out.println(array);
//
//        array.removeFirst();
//        System.out.println(array);

        Array<Student> students = new Array<>();
        students.addLast(new Student("Alice", 100));
        students.addLast(new Student("Bob", 66));
        students.addLast(new Student("Carl", 88));

        System.out.println(students);

        students.addLast(new Student("Dan", 90));

        System.out.println(students);
    }
}
