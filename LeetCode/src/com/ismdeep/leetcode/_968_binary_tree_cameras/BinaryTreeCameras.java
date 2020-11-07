package com.ismdeep.leetcode._968_binary_tree_cameras;

import org.junit.Test;

class Solution {
    public int minCameraCover(TreeNode root) {
        int[] array = dfs(root);
        return array[1];
    }

    public int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{Integer.MAX_VALUE / 2, 0, 0};
        }
        int[] leftArray = dfs(root.left);
        int[] rightArray = dfs(root.right);
        int[] array = new int[3];
        array[0] = leftArray[2] + rightArray[2] + 1;
        array[1] = Math.min(array[0], Math.min(leftArray[0] + rightArray[1], rightArray[0] + leftArray[1]));
        array[2] = Math.min(array[0], leftArray[1] + rightArray[1]);
        return array;
    }
}

public class BinaryTreeCameras {

    public static TreeNode t(int val) {
        return new TreeNode(val);
    }

    public static TreeNode t(int val, TreeNode l, TreeNode r) {
        TreeNode root = new TreeNode(val);
        root.left = l;
        root.right = r;
        return root;
    }

    @Test
    public void test001() {
        TreeNode root =
                t(0,
                        t(0,
                                t(0),
                                t(0)),
                        null);
        assert new Solution().minCameraCover(root) == 1;
    }
}
