package org.kenny.data_structure.course.datastrutures.linkedlist.ImplementStackinLinkedList;

import org.kenny.data_structure.course.datastrutures.linkedlist.LinkedList;
import org.kenny.data_structure.course.datastrutures.stack.Stack;

public class LinkedListStack<E> implements Stack<E> {
    private LinkedList<E> list;
    public LinkedListStack() {
        list = new LinkedList<>();
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
    public void push(E e) {

    }

    @Override
    public E pop() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }
}
