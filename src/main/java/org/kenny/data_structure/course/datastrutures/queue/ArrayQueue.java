package org.kenny.data_structure.course.datastrutures.queue;

public class ArrayQueue<E> implements Queue<E> {

    private DynamicArray<E> array;

    public ArrayQueue(int capacity) {
        array = new DynamicArray<>(capacity);
    }

    public ArrayQueue() {
        array = new DynamicArray<>();
    }
}
