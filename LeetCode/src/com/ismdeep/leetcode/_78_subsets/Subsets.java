package com.ismdeep.leetcode._78_subsets;

import com.ismdeep.leetcode.util.ListUtil;
import org.junit.Test;

import java.util.List;
import java.util.ArrayList;


class Solution {

    public static void dfs(List<List<Integer>> results, List<Integer> items, int[] nums, int index) {
        if (index > nums.length) {
            return;
        }

        if (index == nums.length) {
            results.add(new ArrayList<>(items));
            return;
        }

        items.add(nums[index]);
        dfs(results, items, nums, index + 1);
        items.remove(items.size() - 1);

        dfs(results, items, nums, index + 1);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> items = new ArrayList<>();
        List<List<Integer>> results = new ArrayList<>();
        dfs(results, items, nums, 0);
        return results;
    }
}

public class Subsets {
    @Test
    public void test001() {
        List<List<Integer>> results = new Solution().subsets(new int[]{1, 2, 3});
        System.out.println(ListUtil.dump(results));
    }
}

