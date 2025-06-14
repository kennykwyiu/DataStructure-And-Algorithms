package org.kenny.algorithms.recursion;

import org.kenny.data_structure.tree.TreeNode;

/**
 * Question: Given a binary tree, write a function to find its maximum depth.
 * The maximum depth is defined as the number of nodes along the longest path from the root node to the deepest leaf node.
 *
 * Example:
 *
 * Input:
 *      3
 *     / \
 *    9  20
 *      /  \
 *     15   7
 *
 * Output: 3
 * Explanation: The maximum depth is 3, as the longest path from the root node (3) to any leaf node is [3 -> 20 -> 15] or [3 -> 20 -> 7].
 * Write a function maxDepth that takes the root of a binary tree as input and returns the maximum depth as an integer.
 */
public class MaximumDepthOfBinaryTree {
    private int maxHeight = 0;
    public int findMaxDepth(TreeNode root) {
        compareHeight(root, 1);
        return maxHeight;
    }

    private void compareHeight(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        maxHeight = Math.max(depth, maxHeight);
        compareHeight(root.left, depth + 1);
        compareHeight(root.right, depth + 1);
    }
}
