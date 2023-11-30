package org.kenny.algorithms.linkedlist;

public class RemoveLinkedListElements {
    // Time complexity: O(n), Space complexity: O(1)
    public ListNode removeLinkedListElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode currNode = dummy;

        while (currNode.next != null) {
            if (currNode.next.value == val) {
                currNode.next = currNode.next.next;
            }
            else {
                currNode = currNode.next;
            }
        }
        return dummy.next;
    }
}
