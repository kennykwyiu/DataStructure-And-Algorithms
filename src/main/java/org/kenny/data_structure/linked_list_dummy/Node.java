package org.kenny.data_structure.linked_list_dummy;

public class Node <T> {
    public T value;
    public Node<T> next;

    Node(T value) {
        this.value = value;
    }
}
