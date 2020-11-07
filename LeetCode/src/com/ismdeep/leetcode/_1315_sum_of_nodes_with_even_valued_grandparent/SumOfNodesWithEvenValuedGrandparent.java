package com.ismdeep.leetcode._1315_sum_of_nodes_with_even_valued_grandparent;

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

    public static int dfs(TreeNode current, boolean parent, boolean grandparent) {
        if (current == null) {
            return 0;
        }

        int val = 0;
        boolean me = current.val % 2 == 0;
        if (grandparent) {
            val += current.val;
        }

        val += dfs(current.left, me, parent);
        val += dfs(current.right, me, parent);
        return val;
    }

    public int sumEvenGrandparent(TreeNode root) {
        return dfs(root, false, false);
    }
}

public class SumOfNodesWithEvenValuedGrandparent {
    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    @Test
    public void test001() {
        TreeNode root = stringToTreeNode("[6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]");
        assert new Solution().sumEvenGrandparent(root) == 18;
    }
}
