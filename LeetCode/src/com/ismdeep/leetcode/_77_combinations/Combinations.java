package com.ismdeep.leetcode._77_combinations;

import com.ismdeep.leetcode.util.ListUtil;
import org.junit.Test;

import java.util.List;
import java.util.ArrayList;


class Solution {

    public static void dfs(List<List<Integer>> results, List<Integer> result, List<Integer> items, int k) {
        if (k == 0) {
            results.add(new ArrayList<>(result));
            return;
        }

        if (items.size() <= 0) {
            return;
        }

        for (int itemId = 0; itemId < items.size(); itemId++) {
            result.add(items.get(itemId));
            List<Integer> nextItems = new ArrayList<>();
            for (int i = itemId + 1; i < items.size(); i++) nextItems.add(items.get(i));
            dfs(results, result, nextItems, k - 1);
            result.remove(result.size() - 1);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> items = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            items.add(i);
        }

        List<List<Integer>> results = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        dfs(results, result, items, k);

        return results;
    }
}

public class Combinations {

    @Test
    public void test001() {
        List<List<Integer>> lists = new Solution().combine(4, 2);
        String out = ListUtil.dump(lists);
        System.out.println(out);
    }
}
