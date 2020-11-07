package com.ismdeep.leetcode._226_invert_binary_tree;

import org.junit.Test;


class Solution {

    public static void dfsInvert(TreeNode root) {
        if (root == null) {
            return;
        }

        dfsInvert(root.left);
        dfsInvert(root.right);

        TreeNode tmp;
        tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }

    public TreeNode invertTree(TreeNode root) {
        dfsInvert(root);
        return root;
    }
}

public class InvertBinaryTree {

    @Test
    public void test001() {
        TreeNode node4 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node7 = new TreeNode(7);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node9 = new TreeNode(9);

        node4.left = node2;
        node4.right = node7;
        node2.left = node1;
        node2.right = node3;
        node7.left = node6;
        node7.right = node9;

        TreeNode root = new Solution().invertTree(node4);

    }

}
