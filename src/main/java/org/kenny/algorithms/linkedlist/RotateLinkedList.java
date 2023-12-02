package org.kenny.algorithms.linkedlist;

public class RotateLinkedList {

    public ListNode rotateRight(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        int length = getLength(head);
        n = n % length;

        if (n == 0) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode ahead = dummy;
        for (int i = 0; i < n; i++) {
            ahead = ahead.next;
        }

        ListNode behind = dummy;
        while (ahead.next != null) {
            ahead = ahead.next;
            behind = behind.next;
        }

        ahead.next = dummy.next;
        dummy.next = behind.next;
        behind.next = null;

        return dummy.next;
    }

    private int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

}
