package org.kenny.algorithms.linkedlist;

import org.junit.Assert;
import org.junit.Test;
import org.kenny.algorithms.linkedlist.MergeTwoSortedLinkedList;

public class MergeTwoSortedLinkedListTest {

    @Test
    public void testMergeLists() {
        // Create the first linked list: 1 -> 3 -> 5
        MergeTwoSortedLinkedList.SinglyLinkedListNode head1 = new MergeTwoSortedLinkedList.SinglyLinkedListNode(1);
        MergeTwoSortedLinkedList.SinglyLinkedListNode node2 = new MergeTwoSortedLinkedList.SinglyLinkedListNode(3);
        MergeTwoSortedLinkedList.SinglyLinkedListNode node3 = new MergeTwoSortedLinkedList.SinglyLinkedListNode(5);
        head1.next = node2;
        node2.next = node3;

        // Create the second linked list: 2 -> 4 -> 6
        MergeTwoSortedLinkedList.SinglyLinkedListNode head2 = new MergeTwoSortedLinkedList.SinglyLinkedListNode(2);
        MergeTwoSortedLinkedList.SinglyLinkedListNode node5 = new MergeTwoSortedLinkedList.SinglyLinkedListNode(4);
        MergeTwoSortedLinkedList.SinglyLinkedListNode node6 = new MergeTwoSortedLinkedList.SinglyLinkedListNode(6);
        head2.next = node5;
        node5.next = node6;

        // Expected merged list: 1 -> 2 -> 3 -> 4 -> 5 -> 6
        MergeTwoSortedLinkedList.SinglyLinkedListNode expectedMerged = new MergeTwoSortedLinkedList.SinglyLinkedListNode(1);
        MergeTwoSortedLinkedList.SinglyLinkedListNode node7 = new MergeTwoSortedLinkedList.SinglyLinkedListNode(2);
        MergeTwoSortedLinkedList.SinglyLinkedListNode node8 = new MergeTwoSortedLinkedList.SinglyLinkedListNode(3);
        MergeTwoSortedLinkedList.SinglyLinkedListNode node9 = new MergeTwoSortedLinkedList.SinglyLinkedListNode(4);
        MergeTwoSortedLinkedList.SinglyLinkedListNode node10 = new MergeTwoSortedLinkedList.SinglyLinkedListNode(5);
        MergeTwoSortedLinkedList.SinglyLinkedListNode node11 = new MergeTwoSortedLinkedList.SinglyLinkedListNode(6);
        expectedMerged.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;
        node10.next = node11;

        // Merge the two lists
        MergeTwoSortedLinkedList.SinglyLinkedListNode merged = MergeTwoSortedLinkedList.mergeLists(head1, head2);

        // Compare the merged list with the expected merged list
        while (expectedMerged != null) {
            Assert.assertEquals(expectedMerged.data, merged.data);
            expectedMerged = expectedMerged.next;
            merged = merged.next;
        }
    }
}
