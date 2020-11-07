package com.ismdeep.leetcode._47_permutations_ii;

import com.ismdeep.leetcode.util.ListUtil;
import org.junit.Test;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

class Solution {
    public Set<String> added;

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

    public void dfs(List<List<Integer>> lists, List<Integer> items, int[] nums) {
        if (nums.length <= 0) {
            return;
        }

        if (nums.length == 1) {
            List<Integer> results = new ArrayList<>(items);
            results.add(nums[0]);
            String str = dump(results);
            if (!added.contains(str)) {
                lists.add(results);
                added.add(str);
            }

            return;
        }

        for (int selectId = 0; selectId < nums.length; selectId++) {
            items.add(nums[selectId]);
            int[] nextNums = new int[nums.length - 1];

            for (int i = 0; i < selectId; i++) {
                nextNums[i] = nums[i];
            }
            for (int i = selectId + 1; i < nums.length; i++) {
                nextNums[i - 1] = nums[i];
            }

            dfs(lists, items, nextNums);

            items.remove(items.size() - 1);
        }

    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> items = new ArrayList<>();
        this.added = new HashSet<>();
        dfs(lists, items, nums);
        return lists;
    }
}

public class PermutationsII {

    @Test
    public void test001() {
        List<List<Integer>> lists = new Solution().permuteUnique(new int[]{1, 1, 2});
        System.out.println(ListUtil.dump(lists));
    }
}
