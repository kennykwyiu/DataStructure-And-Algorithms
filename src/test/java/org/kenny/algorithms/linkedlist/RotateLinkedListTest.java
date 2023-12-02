package org.kenny.algorithms.linkedlist;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RotateLinkedListTest {

    @Test
    public void testRotateRight_RotateByTwoPositions() {
        // Create a linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        RotateLinkedList solution = new RotateLinkedList();

        // Rotate by 2 positions
        ListNode rotated = solution.rotateRight(head, 2);

        // Expected result: 4 -> 5 -> 1 -> 2 -> 3
        assertEquals(4, rotated.value);
        assertEquals(5, rotated.next.value);
        assertEquals(1, rotated.next.next.value);
        assertEquals(2, rotated.next.next.next.value);
        assertEquals(3, rotated.next.next.next.next.value);
        assertNull(rotated.next.next.next.next.next);
    }

    @Test
    public void testRotateRight_RotateByZeroPositions() {
        // Create a linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        RotateLinkedList solution = new RotateLinkedList();

        // Rotate by 0 positions
        ListNode rotated = solution.rotateRight(head, 0);

        // Expected result: 1 -> 2 -> 3 -> 4 -> 5
        assertEquals(1, rotated.value);
        assertEquals(2, rotated.next.value);
        assertEquals(3, rotated.next.next.value);
        assertEquals(4, rotated.next.next.next.value);
        assertEquals(5, rotated.next.next.next.next.value);
        assertNull(rotated.next.next.next.next.next);
    }

    @Test
    public void testRotateRight_RotateByLengthOfList() {
        // Create a linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        RotateLinkedList solution = new RotateLinkedList();

        // Rotate by the length of the list (5 positions)
        ListNode rotated = solution.rotateRight(head, 5);

        // Expected result: 1 -> 2 -> 3 -> 4 -> 5
        assertEquals(1, rotated.value);
        assertEquals(2, rotated.next.value);
        assertEquals(3, rotated.next.next.value);
        assertEquals(4, rotated.next.next.next.value);
        assertEquals(5, rotated.next.next.next.next.value);
        assertNull(rotated.next.next.next.next.next);
    }
}
