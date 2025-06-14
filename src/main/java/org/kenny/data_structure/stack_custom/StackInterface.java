package org.kenny.data_structure.stack_custom;

public interface StackInterface<T> {
    T pop();

    void push(T item);

    T peak();

    boolean isEmpty();

    void clear();
}
