package com.ismdeep.leetcode._654_maximum_binary_tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public static int maxIndex(List<Integer> nums) {
        int maxId = 0;
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) > nums.get(maxId)) {
                maxId = i;
            }
        }
        return maxId;
    }

    public static TreeNode dfs(List<Integer> nums) {
        if (nums.size() <= 0) return null;
        if (nums.size() == 1) return new TreeNode(nums.get(0));

        int maxId = maxIndex(nums);
        TreeNode root = new TreeNode(nums.get(maxId));

        List<Integer> numsLeft = new ArrayList<>();
        List<Integer> numsRight = new ArrayList<>();

        for (int i = 0; i < maxId; i++) {
            numsLeft.add(nums.get(i));
        }

        for (int i = maxId + 1; i < nums.size(); i++) {
            numsRight.add(nums.get(i));
        }

        root.left = dfs(numsLeft);
        root.right = dfs(numsRight);

        return root;
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        List<Integer> numList = new ArrayList<>();
        for (int num : nums) {
            numList.add(num);
        }
        return dfs(numList);
    }
}

public class MaximumBinaryTree {
    @Test
    public void test001() {
        TreeNode tree = new Solution().constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});
    }
}
