package org.kenny.data_structure.course.datastrutures.stack;

public interface Stack<E> {
    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();
}
