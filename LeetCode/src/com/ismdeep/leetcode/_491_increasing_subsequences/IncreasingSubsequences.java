package com.ismdeep.leetcode._491_increasing_subsequences;

import com.ismdeep.leetcode.util.ListUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {

    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for (int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }

    public void dfs(int[] nums, int index, List<Integer> currentList, List<List<Integer>> list, HashSet<String> added) {
        if (index >= nums.length) {
            return;
        }

        if (currentList.size() <= 0 || nums[index] >= currentList.get(currentList.size() - 1)) {
            List<Integer> nextList = new ArrayList<>(currentList);
            nextList.add(nums[index]);
            if (nextList.size() >= 2) {
                String str = integerArrayListToString(nextList);
                if (!added.contains(str)) {
                    list.add(nextList);
                    added.add(str);
                }

            }
            for (index = index + 1; index < nums.length; index++) {
                if (nums[index] >= nextList.get(nextList.size() - 1)) {
                    dfs(nums, index, nextList, list, added);
                }
            }
        }
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();

        HashSet<String> added = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            List<Integer> currentList = new ArrayList<>();
            dfs(nums, i, currentList, list, added);
        }

        return list;
    }
}

public class IncreasingSubsequences {

    // TODO: 2020/9/23 完善测试代码

    @Test
    public void test001() {
        List<List<Integer>> results = new Solution().findSubsequences(new int[]{1,2,3,4,5,6,7,8,9,10,1,1,1,1,1});
        System.out.println(ListUtil.dump(results));
    }

    @Test
    public void test002() {
        List<List<Integer>> results = new Solution().findSubsequences(new int[]{4,6,7,7});
        System.out.println(ListUtil.dump(results));
    }

}
