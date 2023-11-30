package org.kenny.algorithms.linkedlist;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kenny.algorithms.linkedlist.ListNode;
import org.kenny.algorithms.linkedlist.RemoveLinkedListElements;

public class RemoveLinkedListElementsTest {

    private ListNode head;

    @BeforeEach
    public void setUp() {
        // Create a sample linked list: 1 -> 2 -> 6 -> 3 -> 4 -> 5 -> 6
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);
    }

    @Test
    public void testRemoveLinkedListElements_RemovingExistingValue() {
        RemoveLinkedListElements solution = new RemoveLinkedListElements();

        // Remove all occurrences of value 6
        ListNode result = solution.removeLinkedListElements(head, 6);

        // Verify that the new linked list is 1 -> 2 -> 3 -> 4 -> 5
        Assert.assertEquals(1, result.value);
        Assert.assertEquals(2, result.next.value);
        Assert.assertEquals(3, result.next.next.value);
        Assert.assertEquals(4, result.next.next.next.value);
        Assert.assertEquals(5, result.next.next.next.next.value);
        Assert.assertNull(result.next.next.next.next.next);
    }

    @Test
    public void testRemoveLinkedListElements_RemovingNonExistingValue() {
        RemoveLinkedListElements solution = new RemoveLinkedListElements();

        // Remove all occurrences of value 8 (non-existing)
        ListNode result = solution.removeLinkedListElements(head, 8);

        // Verify that the linked list remains unchanged
        Assert.assertEquals(1, result.value);
        Assert.assertEquals(2, result.next.value);
        Assert.assertEquals(6, result.next.next.value);
        Assert.assertEquals(3, result.next.next.next.value);
        Assert.assertEquals(4, result.next.next.next.next.value);
        Assert.assertEquals(5, result.next.next.next.next.next.value);
        Assert.assertEquals(6, result.next.next.next.next.next.next.value);
        Assert.assertNull(result.next.next.next.next.next.next.next);
    }
}
