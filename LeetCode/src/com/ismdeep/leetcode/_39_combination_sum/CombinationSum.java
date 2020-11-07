package com.ismdeep.leetcode._39_combination_sum;

import com.ismdeep.leetcode.util.ListUtil;
import org.junit.Test;

import java.util.List;
import java.util.ArrayList;

class Solution {

    public void dfs(List<List<Integer>> results, List<Integer> values, int[] items, int start, int target) {
        if (target == 0) return;
        if (start >= items.length) return;

        if (items[start] == target) {
            List<Integer> result = new ArrayList<>(values);
            result.add(target);
            results.add(result);
        }

        if (items[start] < target) {
            values.add(items[start]);
            dfs(results, values, items, start, target - items[start]);
            values.remove(values.size() - 1);
        }
        dfs(results, values, items, start + 1, target);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        dfs(results, new ArrayList<Integer>(), candidates, 0, target);
        return results;
    }
}

public class CombinationSum {
    @Test
    public void test001() {
        List<List<Integer>> results = new Solution().combinationSum(new int[]{2, 3, 6, 7}, 7);
        System.out.println(ListUtil.dump(results));
    }

    @Test
    public void test002() {
        List<List<Integer>> results = new Solution().combinationSum(new int[]{4, 2, 8}, 8);
        System.out.println(ListUtil.dump(results));
    }
}
