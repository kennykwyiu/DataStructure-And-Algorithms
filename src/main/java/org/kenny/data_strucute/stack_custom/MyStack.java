package org.kenny.data_strucute.stack_custom;

import java.util.EmptyStackException;

public class MyStack<T> implements StackInterface<T> {
    private StackNode<T> top;

    @Override
    public T pop() {
        if (top == null) {
            throw new EmptyStackException();
        }
        final T item = top.getData();
        top = top.getNext();
        return item;
    }

    @Override
    public void push(T item) {
        final StackNode<T> node = new StackNode<>(item);
        node.setNext(top);
        top = node;
    }

    @Override
    public T peak() {
        if (top == null) {
            throw new EmptyStackException();
        }
        return top.getData();
    }

    public static void main(String[] args) {
        MyStack<Integer> integerMyStack = new MyStack<>();
        integerMyStack.push(1);
        System.out.println(integerMyStack.peak());
    }
}
