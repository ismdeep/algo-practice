package com.ismdeep.leetcode._113_path_sum_ii;

import com.ismdeep.leetcode.util.ListUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


class Solution {

    private List<List<Integer>> results;
    private int target;

    public static boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    public void dfs(TreeNode root, List<Integer> path) {
        if (root == null) return;

        path.add(root.val);

        if (isLeaf(root)) {
            int tmpSum = 0;
            for (int val : path) {
                tmpSum += val;
            }
            if (tmpSum == target) {
                results.add(new ArrayList<>(path));
            }
        }

        if (root.left != null) {
            dfs(root.left, path);
        }
        if (root.right != null) {
            dfs(root.right, path);
        }

        path.remove(path.size() - 1);


    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        results = new ArrayList<>();
        target = sum;
        List<Integer> path = new ArrayList<>();
        dfs(root, path);
        return results;
    }
}

public class PathSumII {

    public static TreeNode t(int val) {
        return new TreeNode(val);
    }

    public static TreeNode t(int val, TreeNode l, TreeNode r) {
        return new TreeNode(val, l, r);
    }

    @Test
    public void test001() {
        TreeNode root =
                t(5,
                        t(4,
                                t(11,
                                        t(7),
                                        t(2)),
                                null),
                        t(8,
                                t(13),
                                t(4,
                                        t(5),
                                        t(1))));
        List<List<Integer>> results = new Solution().pathSum(root, 22);
        System.out.println(ListUtil.dump(results));
    }
}
