package com.ismdeep.leetcode._617_merge_two_binary_trees;

import org.junit.Test;

class Solution {

    public void dfs(TreeNode root, TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return;
        }
        root.val = (root1 != null ? root1.val : 0) + (root2 != null ? root2.val : 0);
        if ((root1 != null && root1.left != null) || (root2 != null && root2.left != null)) {
            root.left = new TreeNode(0);
            dfs(root.left, root1 != null ? root1.left : null, root2 != null ? root2.left : null);
        }
        if ((root1 != null && root1.right != null) || (root2 != null && root2.right != null)) {
            root.right = new TreeNode(0);
            dfs(root.right, root1 != null ? root1.right : null, root2 != null ? root2.right : null);
        }
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        TreeNode root = new TreeNode(0);
        dfs(root, t1, t2);
        return root;
    }
}

public class MergeTwoBinaryTrees {

    @Test
    public void test001() {
        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(3);
        tree1.right = new TreeNode(2);
        tree1.left.left = new TreeNode(5);

        TreeNode tree2 = new TreeNode(2);
        tree2.left = new TreeNode(1);
        tree2.right = new TreeNode(3);
        tree2.left.right = new TreeNode(4);
        tree2.right.right = new TreeNode(7);

        TreeNode mergedTree = new Solution().mergeTrees(tree1, tree2);
        assert mergedTree.val == 3;
        assert mergedTree.left.val == 4;
        assert mergedTree.right.val == 5;
        assert mergedTree.left.left.val == 5;
        assert mergedTree.left.right.val == 4;
        assert mergedTree.right.right.val == 7;
    }
}
