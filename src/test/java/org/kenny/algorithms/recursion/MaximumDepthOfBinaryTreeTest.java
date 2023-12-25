package org.kenny.algorithms.recursion;

import org.junit.Test;
import org.kenny.data_strucute.tree.TreeNode;

import static org.junit.Assert.assertEquals;

public class MaximumDepthOfBinaryTreeTest {

    @Test
    public void testFindMaxDepth_EmptyTree() {
        // Test case with an empty binary tree
        TreeNode root = null;

        MaximumDepthOfBinaryTree tree = new MaximumDepthOfBinaryTree();

        int maxDepth = tree.findMaxDepth(root);

        // Since the tree is empty, the maximum depth should be 0
        assertEquals(0, maxDepth);
    }

    @Test
    public void testFindMaxDepth_SingleNodeTree() {
        // Test case with a binary tree having only one node
        TreeNode root = new TreeNode(5);

        MaximumDepthOfBinaryTree tree = new MaximumDepthOfBinaryTree();

        int maxDepth = tree.findMaxDepth(root);

        // Since there is only one node, the maximum depth should be 1
        assertEquals(1, maxDepth);
    }

    @Test
    public void testFindMaxDepth_GenericTree() {
        // Test case with a generic binary tree
        /*
                 3
                / \
               9  20
                 /  \
                15   7
        */
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        MaximumDepthOfBinaryTree tree = new MaximumDepthOfBinaryTree();

        int maxDepth = tree.findMaxDepth(root);

        // The maximum depth of the tree should be 3
        assertEquals(3, maxDepth);
    }
}

