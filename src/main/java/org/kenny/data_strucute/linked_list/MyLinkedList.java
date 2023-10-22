package org.kenny.data_strucute.linked_list;

import org.junit.Test;

public class MyLinkedList {
    private static Node head;

    // create
    public void add(int location, int value) {
        if (location > 0) {
            Node pre = head;
            for (int i = 0; i < location - 1; i++) {
                pre = pre.next;
            }
            Node newNode = new Node(value);
            newNode.next = pre.next;
            pre.next = newNode;
        } else {
            Node newNode = new Node(value);
            newNode.next = head;
            head = newNode;
        }
    }

    // read
    public int get (int location) {
        Node cur = head;
        for (int i = 0; i < location; i++) {
            cur = cur.next;
        }
        return (int) cur.value;
    }

    // update
    public void set(int location, int newValue) {
        Node cur = head;
        for (int i = 0; i < location; i++) {
            cur = cur.next;
        }
        cur.value = newValue;
    }

    // delete
    public int remove(int location) {
        Node result = null;

        if (location > 0 ) {
            Node cur = head;
            for (int i = 0; i < location - 1; i++) {
                cur = cur.next;
            }
            result = cur.next;
            cur.next = cur.next.next;
        } else if (location == 0) {
            result = head;
            head = head.next;
        }
        return (int) result.value;
    }

    public void travers(Node head) {
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }

    public void travers() {
        travers(head);
    }

    @Test
    public void main() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(0, 1);
        myLinkedList.add(1, 3);
        myLinkedList.add(2, 5);
        myLinkedList.add(3, 7);

        travers(head);
        add(0, 10);
        System.out.println();
        travers(head);
        System.out.println();
        System.out.println(remove(0));
        travers(head);
    }

}
