package com.ismdeep.leetcode._53_maximum_subarray;

import org.junit.Test;

class Solution {
    public int maxSubArray(int[] nums) {
        int val = 0;
        int maxVal = Integer.MIN_VALUE;
        for (int num : nums) {
            if (val >= 0) {
                val += num;
            } else {
                val = num;
            }
            if (val > maxVal) {
                maxVal = val;
            }
        }
        return maxVal;
    }
}

public class MaximumSubarray {
    @Test
    public void test001() {
        assert new Solution().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}) == 6;
    }
}