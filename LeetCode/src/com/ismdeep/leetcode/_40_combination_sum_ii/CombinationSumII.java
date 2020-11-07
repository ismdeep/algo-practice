package com.ismdeep.leetcode._40_combination_sum_ii;

import com.ismdeep.leetcode.util.ListUtil;
import org.junit.Test;

import java.util.*;


class Solution {
    public static String dump(List<?> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        boolean first = true;
        for (Object item : list) {
            if (!first) {
                sb.append(",");
            }
            first = false;
            if (item.getClass().getTypeName().equals("java.lang.String")) {
                sb.append(String.format("\"%s\"", item));
            } else if (item.getClass().getTypeName().equals("java.util.ArrayList")) {
                sb.append(dump((List<?>) item));
            } else {
                sb.append(item.toString());
            }

        }

        sb.append("]");
        return sb.toString();
    }

    public static void dfs(List<List<Integer>> results, Set<String> added, List<Integer> items, int[] candidates, int start, int target) {
        int n = candidates.length;
        if (start >= n) {
            return;
        }

        if (candidates[start] == target) {
            List<Integer> result = new ArrayList<>(items);
            result.add(candidates[start]);
            String str = dump(result);
            if (!added.contains(str)) {
                results.add(result);
                added.add(str);
            }
            return;
        }

        if (candidates[start] < target) {
            items.add(candidates[start]);
            dfs(results, added, items, candidates, start + 1, target - candidates[start]);
            items.remove(items.size() - 1);
        }

        dfs(results, added, items, candidates, start + 1, target);

    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> items = new ArrayList<>();
        Set<String> added = new HashSet<>();
        Arrays.sort(candidates);

        dfs(results, added, items, candidates, 0, target);

        return results;
    }
}

public class CombinationSumII {
    @Test
    public void test001() {
        List<List<Integer>> results = new Solution().combinationSum2(new int[]{2, 5, 2, 1, 2}, 5);
        System.out.println(ListUtil.dump(results));
    }
}
