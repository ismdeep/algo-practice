package com.ismdeep.leetcode._538_convert_bst_to_greater_tree;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.PriorityQueue;

class Solution {

    private int val;

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.right);

        val += root.val;
        root.val = val;

        dfs(root.left);
    }

    public TreeNode convertBST(TreeNode root) {
        val = 0;
        dfs(root);
        return root;
    }
}

public class ConvertBstToGreaterTree {

    @Test
    public void test001() {
        TreeNode node5 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2);
        TreeNode node13 = new TreeNode(13);

        node5.left = node2;
        node5.right = node13;

        TreeNode ans = new Solution().convertBST(node5);
        assert ans.val == 18;
        assert ans.left.val == 20;
        assert ans.right.val == 13;
    }
}
