package com.ismdeep.leetcode._1302_deepest_leaves_sum;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    /**
     * 返回最深叶子层次
     *
     * @param root
     * @param level
     * @return
     */
    public static int dfs(Map<Integer, Integer> leavesSum, TreeNode root, int level) {
        if (root.left == null && root.right == null) {
            if (!leavesSum.containsKey(level)) {
                leavesSum.put(level, 0);
            }
            leavesSum.put(level, leavesSum.get(level) + root.val);
            return level;
        }


        int leftMaxLevel = level;
        int rightMaxLevel = level;
        if (root.left != null) {
            leftMaxLevel = dfs(leavesSum, root.left, level + 1);
        }
        if (root.right != null) {
            rightMaxLevel = dfs(leavesSum, root.right, level + 1);
        }

        return Math.max(leftMaxLevel, rightMaxLevel);

    }

    public int deepestLeavesSum(TreeNode root) {
        Map<Integer, Integer> leavesSum = new HashMap<>();

        int maxLeaveLevel = dfs(leavesSum, root, 1);
        return leavesSum.get(maxLeaveLevel);
    }
}

public class DeepestLeavesSum {
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
    public void test() {
        TreeNode root = stringToTreeNode("[1,2,3,4,5,null,6,7,null,null,null,null,8]");
        assert new Solution().deepestLeavesSum(root) == 15;
    }
}
