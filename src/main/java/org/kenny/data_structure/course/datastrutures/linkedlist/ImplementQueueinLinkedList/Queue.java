package org.kenny.data_structure.course.datastrutures.linkedlist.ImplementQueueinLinkedList;

public interface Queue<E> {
    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();
}
