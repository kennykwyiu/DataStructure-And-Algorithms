package org.kenny.data_strucute.linked_list;

public class Node <T> {
    public T value;
    public Node<T> next;

    public Node(T value) {
        this.value = value;
    }
}
