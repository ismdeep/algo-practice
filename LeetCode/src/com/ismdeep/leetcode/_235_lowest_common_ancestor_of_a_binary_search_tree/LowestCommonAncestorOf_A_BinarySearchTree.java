package com.ismdeep.leetcode._235_lowest_common_ancestor_of_a_binary_search_tree;

import org.junit.Test;


class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode cursor = root;

        while (true) {
            if (p.val < cursor.val && q.val < cursor.val) {
                cursor = cursor.left;
            } else if (p.val > cursor.val && q.val > cursor.val) {
                cursor = cursor.right;
            } else {
                break;
            }
        }

        return cursor;
    }
}

public class LowestCommonAncestorOf_A_BinarySearchTree {
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
                __(6,
                        __(2,
                                0,
                                __(4,
                                        3,
                                        5)),
                        __(8,
                                7,
                                9));
        assert new Solution().lowestCommonAncestor(root, root.left, root.right) == root;
        assert new Solution().lowestCommonAncestor(root, root.left.left, root.left.right.left) == root.left;
    }
}
