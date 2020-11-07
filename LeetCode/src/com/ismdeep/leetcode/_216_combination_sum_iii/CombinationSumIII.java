package com.ismdeep.leetcode._216_combination_sum_iii;

import com.ismdeep.leetcode.util.ListUtil;
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

    /**
     *
     * @param results 存储结果集
     * @param items 存储已添加的结果
     * @param start 数值起点
     * @param k 所需增加的个数
     * @param target 目标值
     */
    public static void dfs(List<List<Integer>> results, List<Integer> items, int start, int k, int target) {
        if (k <= 0) {
            return;
        }

        if (start > 9) {
            return;
        }

        if (start > target) {
            return;
        }

        if (start == target && k == 1) {
            List<Integer> result = new ArrayList<>(items);
            result.add(start);
            results.add(result);
            return;
        }

        items.add(start);
        dfs(results, items, start + 1, k - 1, target - start);
        items.remove(items.size() - 1);

        dfs(results, items, start + 1, k, target);
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> items = new ArrayList<>();
        dfs(results, items,1, k, n);
        return results;
    }
}

public class CombinationSumIII {

    @Test
    public void test001() {
        List<List<Integer>> results = new Solution().combinationSum3(3, 7);
        System.out.println(ListUtil.dump(results));
    }

    @Test
    public void test002() {
        List<List<Integer>> results = new Solution().combinationSum3(3, 9);
        System.out.println(ListUtil.dump(results));
    }

}
