package com.ismdeep.leetcode._404_sum_of_left_leaves;

import org.junit.Test;

class Solution {
    public int dfs(TreeNode root, boolean isLeft) {
        if (null == root) {
            return 0;
        }

        if (root.left == null && root.right == null && isLeft) {
            return root.val;
        }

        return dfs(root.left, true) + dfs(root.right, false);
    }

    public int sumOfLeftLeaves(TreeNode root) {
        return dfs(root, false);
    }
}

public class SumOfLeftLeaves {

    @Test
    public void test001() {
        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        node3.left = node9;
        node3.right = node20;
        node20.left = node15;
        node20.right = node7;
        assert new Solution().sumOfLeftLeaves(node3) == 24;
    }

}
