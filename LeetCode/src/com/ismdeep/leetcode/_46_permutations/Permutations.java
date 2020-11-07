package com.ismdeep.leetcode._46_permutations;

import com.ismdeep.leetcode.util.ListUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


class Solution {

    public void dfs(List<List<Integer>> lists, List<Integer> items, int[] nums) {
        if (nums.length <= 0) {
            return;
        }

        if (nums.length == 1) {
            List<Integer> results = new ArrayList<>(items);
            results.add(nums[0]);
            lists.add(results);
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

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> items = new ArrayList<>();
        dfs(lists, items, nums);
        return lists;
    }
}

public class Permutations {
    @Test
    public void test001() {
        List<List<Integer>> lists = new Solution().permute(new int[]{1, 2, 3});
        System.out.println(ListUtil.dump(lists));
    }
}
