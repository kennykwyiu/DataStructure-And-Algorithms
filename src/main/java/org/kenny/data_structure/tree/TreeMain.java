package org.kenny.data_structure.tree;

public class TreeMain {
    public static void main(String[] args) {
        TreeNode root = buildTree();
        postorderTraverse(root);
    }

    public static TreeNode buildTree() {
        TreeNode root = new TreeNode(8);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(10);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(14);
        TreeNode node7 = new TreeNode(4);
        TreeNode node8 = new TreeNode(7);
        TreeNode node9 = new TreeNode(13);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        node5.left = node7;
        node5.right = node8;
        node6.left = node9;
        return root;
    }

    public static void traversTree(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.value + " ");
        traversTree(root.left);
        traversTree(root.right);
    }

    public static void preorderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.value + " ");
        preorderTraverse(root.left);
        preorderTraverse(root.right);
    }

    public static void inorderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraverse(root.left);
        System.out.print(root.value + " ");
        inorderTraverse(root.right);
    }

    public static void postorderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        postorderTraverse(root.left);
        postorderTraverse(root.right);
        System.out.print(root.value + " ");
    }

}
