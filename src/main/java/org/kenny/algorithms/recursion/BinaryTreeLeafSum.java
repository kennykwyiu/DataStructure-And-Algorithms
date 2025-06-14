package org.kenny.algorithms.recursion;

import org.kenny.data_structure.tree.TreeNode;

/**
 * Here's a question related to calculating the sum of leaf nodes in a binary tree:
 * <p>
 * Question: Given a binary tree, write a function to calculate the sum of all leaf nodes.
 * Each node in the tree contains a value and has either zero or two children.
 * The leaf nodes are the nodes that do not have any children.
 * Implement the function `binaryTreeLeafSum` that takes the root of the binary tree as input and returns the sum of all leaf node values.
 * <p>
 * For example, given the following binary tree:
 * <p>
 * ```
 *        5
 *       / \
 *      3   8
 *     / \   \
 *    2   4   9
 *   /       / \
 * 1       7   10
 * ```
 * <p>
 * The leaf nodes are 1, 4, 7, and 10. The sum of these leaf nodes is 1 + 4 + 7 + 10 = 22.
 * <p>
 * Write the `binaryTreeLeafSum` function in a programming language of your choice and provide the solution to the problem.
 */
public class BinaryTreeLeafSum {
    private int sum = 0;
    public int findLeafSum(TreeNode root) {
        sum = 0;
        traverse(root);
        return sum;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
           sum += root.value;
        }
        traverse(root.left);
        traverse(root.right);
    }
}
