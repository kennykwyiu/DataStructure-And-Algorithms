package org.kenny.data_strucute.linked_list_dummy;

import org.junit.Test;

public class MyLinkedListDummy {
    private static Node dummy = new Node(-1);

    // create
    public void add(int location, int value) {
        Node pre = dummy;
        for (int i = 0; i < location; i++) {
            pre = pre.next;
        }
        Node newNode = new Node(value);
        newNode.next = pre.next;
        pre.next = newNode;
    }

    // read
    public int get (int location) {
        Node cur = dummy.next;
        for (int i = 0; i < location; i++) {
            cur = cur.next;
        }
        return (int) cur.value;
    }

    // update
    public void set(int location, int newValue) {
        Node cur = dummy.next;
        for (int i = 0; i < location; i++) {
            cur = cur.next;
        }
        cur.value = newValue;
    }

    // delete
    public int remove(int location) {
        Node result = null;

        Node cur = dummy;
        for (int i = 0; i < location; i++) {
            cur = cur.next;
        }
        result = cur.next;
        cur.next = cur.next.next;

        return (int) result.value;
    }

    public void travers(Node head) {
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }

    public void travers() {
        travers(dummy.next);
    }

    @Test
    public void main() {
        MyLinkedListDummy myLinkedListDummy = new MyLinkedListDummy();
        myLinkedListDummy.add(0, 1);
        myLinkedListDummy.add(1, 3);
        myLinkedListDummy.add(2, 5);
        myLinkedListDummy.add(3, 7);

        travers(dummy.next);
        add(0, 10);
        System.out.println();
        travers(dummy.next);
        System.out.println();
        System.out.println(remove(0));
        travers(dummy.next);
    }

}
