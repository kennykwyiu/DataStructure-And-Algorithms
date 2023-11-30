package org.kenny.data_strucute.linked_list;

import java.util.List;

/**
 * Find the middle node of a linked list
 */
public class MiddleOfLinkedList {
    public ListNode findMiddleNode(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
