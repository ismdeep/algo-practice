package com.ismdeep.leetcode._167_two_sum_ii_input_array_is_sorted;

import com.ismdeep.leetcode.util.ArrayUtil;
import org.junit.Test;

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i + 1, j + 1};
                }
            }
        }
        return new int[]{0, 0};
    }
}

public class TwoSum_II_InputArrayIsSorted {
    @Test
    public void test001() {
        int[] ids = new Solution().twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(ArrayUtil.dumpInt(ids));
    }
}
