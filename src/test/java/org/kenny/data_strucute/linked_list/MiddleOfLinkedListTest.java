package org.kenny.data_strucute.linked_list;
import org.junit.Assert;
import org.junit.Test;

public class MiddleOfLinkedListTest {

    @Test
    public void testFindMiddleNodeWithEmptyList() {
        ListNode emptyList = null;
        MiddleOfLinkedList middleOfLinkedList = new MiddleOfLinkedList();
        ListNode result = middleOfLinkedList.findMiddleNode(emptyList);
        Assert.assertNull(result);
    }

    @Test
    public void testFindMiddleNodeWithSingleNode() {
        ListNode singleNode = new ListNode(10);
        MiddleOfLinkedList middleOfLinkedList = new MiddleOfLinkedList();
        ListNode result = middleOfLinkedList.findMiddleNode(singleNode);
        Assert.assertEquals(singleNode, result);
    }

    @Test
    public void testFindMiddleNodeWithOddNumberOfNodes() {
        ListNode oddNodes = new ListNode(1);
        oddNodes.next = new ListNode(2);
        oddNodes.next.next = new ListNode(3);
        oddNodes.next.next.next = new ListNode(4);
        oddNodes.next.next.next.next = new ListNode(5);
        MiddleOfLinkedList middleOfLinkedList = new MiddleOfLinkedList();
        ListNode result = middleOfLinkedList.findMiddleNode(oddNodes);
        Assert.assertEquals(3, result.value);
    }

    @Test
    public void testFindMiddleNodeWithEvenNumberOfNodes() {
        ListNode evenNodes = new ListNode(1);
        evenNodes.next = new ListNode(2);
        evenNodes.next.next = new ListNode(3);
        evenNodes.next.next.next = new ListNode(4);
        MiddleOfLinkedList middleOfLinkedList = new MiddleOfLinkedList();
        ListNode result = middleOfLinkedList.findMiddleNode(evenNodes);
        Assert.assertEquals(2, result.value);
    }

    @Test
    public void testFindMiddleNodeWithLargeList() {
        ListNode largeList = new ListNode(1);
        ListNode currentNode = largeList;
        for (int i = 2; i <= 1000; i++) {
            currentNode.next = new ListNode(i);
            currentNode = currentNode.next;
        }
        MiddleOfLinkedList middleOfLinkedList = new MiddleOfLinkedList();
        ListNode result = middleOfLinkedList.findMiddleNode(largeList);
        Assert.assertEquals(500, result.value);
    }
}
