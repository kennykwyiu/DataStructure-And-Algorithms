package org.kenny.data_structure.course.datastrutures.array.dynamicarray;


public class Main {
    public static void main(String[] args) {
        DynamicArray<Integer> array = new DynamicArray<>();
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        System.out.println(array);
        array.add(1, 100);
        System.out.println(array);

        array.addFirst(-1);
        System.out.println(array);
    }
}
