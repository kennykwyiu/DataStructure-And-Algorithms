package org.kenny.data_strucute.linked_list;

public class InsertNodeILinkedList {

    // Time complexity: O(n)
    public ListNode insertNodeILinkedList(ListNode head, int val) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode currentNode = dummy;

        while (currentNode.next != null && currentNode.next.value <= val) {
            currentNode = currentNode.next;
        }

        ListNode newNode = new ListNode(val);
        newNode.next = currentNode.next;
        currentNode.next = newNode;

        return dummy.next;
    }

}

class ListNode {
    public int value;
    public ListNode next;

    public ListNode(int value) {
        this.value = value;
    }
}
