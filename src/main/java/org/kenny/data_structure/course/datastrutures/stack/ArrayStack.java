package org.kenny.data_structure.course.datastrutures.stack;

import org.kenny.data_structure.course.datastrutures.array.dynamicarray.DynamicArray;

public class ArrayStack<E> implements Stack {
    DynamicArray<E> array;

    public ArrayStack(int capacity) {
        array = new DynamicArray<>(capacity);
    }

    public ArrayStack() {
        array = new DynamicArray<>();
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void push(Object o) {

    }

    @Override
    public Object pop() {
        return null;
    }

    @Override
    public Object peek() {
        return null;
    }
}
