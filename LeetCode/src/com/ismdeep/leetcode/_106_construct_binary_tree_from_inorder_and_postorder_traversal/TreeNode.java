package com.ismdeep.leetcode._106_construct_binary_tree_from_inorder_and_postorder_traversal;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    TreeNode(int x, TreeNode l, TreeNode r) {
        val = x;
        this.left = l;
        this.right = r;
    }
}