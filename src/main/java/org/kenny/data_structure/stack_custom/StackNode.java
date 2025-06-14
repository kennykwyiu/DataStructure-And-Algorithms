package org.kenny.data_structure.stack_custom;

public class StackNode<T> {
    private T data;
    private StackNode<T> next;

    public StackNode(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public StackNode<T> getNext() {
        return next;
    }

    public void setNext(StackNode<T> next) {
        this.next = next;
    }
}
