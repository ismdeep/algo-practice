package com.ismdeep.leetcode._701_insert_into_a_binary_search_tree;

import org.junit.Test;


class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        TreeNode cursor = root;

        while (true) {
            if (val <= cursor.val) {
                if (cursor.left == null) {
                    cursor.left = new TreeNode(val);
                    break;
                }
                cursor = cursor.left;
            } else {
                if (cursor.right == null) {
                    cursor.right = new TreeNode(val);
                    break;
                }
                cursor = cursor.right;
            }
        }

        return root;
    }
}

public class InsertInto_A_BinarySearchTree {
    public static TreeNode __(int val) {
        return new TreeNode(val);
    }

    public static TreeNode __(int val, TreeNode l, TreeNode r) {
        TreeNode node = new TreeNode(val);
        node.left = l;
        node.right = r;
        return node;
    }

    public static TreeNode __(int val, int leftVal, int rightVal) {
        return __(val, __(leftVal), __(rightVal));
    }

    public static TreeNode __(int val, int leftVal, TreeNode right) {
        return __(val, __(leftVal), right);
    }

    public static TreeNode __(int val, TreeNode left, int rightVal) {
        return __(val, left, __(rightVal));
    }

    @Test
    public void test001() {
        TreeNode root =
                __(4,
                        __(2,
                                1,
                                3),
                        7);
        TreeNode insertResultTree = new Solution().insertIntoBST(root, 5);
        System.out.println(insertResultTree.val);
    }
}
