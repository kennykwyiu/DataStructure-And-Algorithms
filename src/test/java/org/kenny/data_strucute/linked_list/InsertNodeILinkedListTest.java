package org.kenny.data_strucute.linked_list;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InsertNodeILinkedListTest {

    private ListNode head;

    @BeforeEach
    public void setUp() {
        // Create a sample linked list: 1 -> 3 -> 5
        head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(5);
    }

    @Test
    public void testInsertNodeILinkedList_InsertInMiddle() {
        InsertNodeILinkedList solution = new InsertNodeILinkedList();

        // Insert a node with value 4
        ListNode result = solution.insertNodeILinkedList(head, 4);

        // Verify that the new linked list is 1 -> 3 -> 4 -> 5
        Assert.assertEquals(1, result.value);
        Assert.assertEquals(3, result.next.value);
        Assert.assertEquals(4, result.next.next.value);
        Assert.assertEquals(5, result.next.next.next.value);
        Assert.assertNull(result.next.next.next.next);
    }

    @Test
    public void testInsertNodeILinkedList_InsertAtBeginning() {
        InsertNodeILinkedList solution = new InsertNodeILinkedList();

        // Insert a node with value 2
        ListNode result = solution.insertNodeILinkedList(null, 2);

        // Verify that the new linked list is 2
        Assert.assertEquals(2, result.value);
        Assert.assertNull(result.next);
    }

    @Test
    public void testInsertNodeILinkedList_InsertAtEnd() {
        InsertNodeILinkedList solution = new InsertNodeILinkedList();

        // Insert a node with value 6
        ListNode result = solution.insertNodeILinkedList(head, 6);

        // Verify that the new linked list is 1 -> 3 -> 5 -> 6
        Assert.assertEquals(1, result.value);
        Assert.assertEquals(3, result.next.value);
        Assert.assertEquals(5, result.next.next.value);
        Assert.assertEquals(6, result.next.next.next.value);
        Assert.assertNull(result.next.next.next.next);
    }
}
