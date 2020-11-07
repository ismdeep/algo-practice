package com.ismdeep.leetcode._637_average_of_levels_in_binary_tree;

import com.ismdeep.leetcode.util.ListUtil;
import org.junit.Test;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Double> results = new ArrayList<>();
        while (!queue.isEmpty()) {
            int n = 0;
            double sum = 0;
            List<TreeNode> nodes = new ArrayList<>();
            while (!queue.isEmpty()) {
                ++n;
                TreeNode cursor = queue.poll();
                sum += cursor.val;
                if (cursor.left != null) {
                    nodes.add(cursor.left);
                }
                if (cursor.right != null) {
                    nodes.add(cursor.right);
                }
            }

            results.add((double) sum / n);

            queue.addAll(nodes);
        }
        return results;
    }
}

public class AverageOfLevelsInBinaryTree {

    @Test
    public void test001() {
        TreeNode node7 = new TreeNode(7);
        TreeNode node15 = new TreeNode(15);
        TreeNode node20 = new TreeNode(20);
        TreeNode node9 = new TreeNode(9);
        TreeNode node3 = new TreeNode(3);
        node3.left = node9;
        node3.right = node20;
        node20.left = node15;
        node20.right = node7;

        List<Double> results = new Solution().averageOfLevels(node3);
        System.out.println(ListUtil.dump(results));
    }

}
