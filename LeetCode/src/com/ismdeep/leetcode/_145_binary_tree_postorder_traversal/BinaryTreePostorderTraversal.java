package com.ismdeep.leetcode._145_binary_tree_postorder_traversal;

import com.ismdeep.leetcode.util.ListUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


class Solution {

    List<Integer> traversalResult;

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.left);
        dfs(root.right);
        traversalResult.add(root.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        traversalResult = new ArrayList<>();

        dfs(root);

        return traversalResult;
    }
}

public class BinaryTreePostorderTraversal {
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
                __(1,
                        null,
                        __(2,
                                3,
                                null));
        List<Integer> traversalResult = new Solution().postorderTraversal(root);
        System.out.println(ListUtil.dump(traversalResult));
    }
}
