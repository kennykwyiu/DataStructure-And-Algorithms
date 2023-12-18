package org.kenny.algorithms.recursion;
import org.junit.jupiter.api.Test;
import org.kenny.data_strucute.tree.TreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryTreeLeafSumTest {
    @Test
    public void testBinaryTreeLeafSum() {
        // Create a binary tree
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        root.right.right = new TreeNode(9);
        root.right.right.left = new TreeNode(7);
        root.right.right.right = new TreeNode(10);

        BinaryTreeLeafSum leafSum = new BinaryTreeLeafSum();

        // Test the sum of leaf nodes
        int sum = leafSum.findLeafSum(root);
        assertEquals(22, sum, "Sum of leaf nodes in the binary tree should be 22");
    }

    @Test
    public void testBinaryTreeLeafSumWithNullRoot() {
        // Create an empty binary tree (null root)
        TreeNode root = null;
        BinaryTreeLeafSum leafSum = new BinaryTreeLeafSum();

        // Test the sum of leaf nodes
        int sum = leafSum.findLeafSum(root);
        assertEquals(0, sum, "Sum of leaf nodes in an empty tree should be 0");
    }
}
