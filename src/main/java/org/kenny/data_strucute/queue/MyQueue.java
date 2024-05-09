package org.kenny.data_strucute.queue;

import org.kenny.data_strucute.linked_list.Node;

import java.util.NoSuchElementException;

public class MyQueue {
    private Node<Integer> head;
    private Node<Integer> tail;

    public void offer(int value) {
        if (tail == null) {
            head = tail = new Node<>(value); 
        } else {
            tail.next = new Node<>(value);
            tail = tail.next;
        }
    }

    public int poll() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        int returnValue = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return returnValue;
    }

    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return head.value;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void clear() {
        head = tail = null;
    }
}
