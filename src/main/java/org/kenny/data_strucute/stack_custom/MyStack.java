package org.kenny.data_strucute.stack_custom;

import java.util.NoSuchElementException;


public class MyStack<T> implements StackInterface<T> {
    private StackNode<T> top;

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        final T item = top.getData();
        top = top.getNext();
        return item;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public void clear() {
        top = null;
    }

    @Override
    public void push(T item) {
        final StackNode<T> node = new StackNode<>(item);
        node.setNext(top);
        top = node;
    }

    @Override
    public T peak() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return top.getData();
    }

    public static void main(String[] args) {
        MyStack<Integer> integerMyStack = new MyStack<>();
        integerMyStack.push(1);
        System.out.println(integerMyStack.peak());
    }
}
