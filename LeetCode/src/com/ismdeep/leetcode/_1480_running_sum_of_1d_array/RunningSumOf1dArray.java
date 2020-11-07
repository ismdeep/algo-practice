package com.ismdeep.leetcode._1480_running_sum_of_1d_array;

import com.ismdeep.leetcode.util.ArrayUtil;
import org.junit.Test;

class Solution {
    public int[] runningSum(int[] nums) {
        int currentSum = 0;
        int[] sums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            sums[i] = currentSum;
        }
        return sums;
    }
}

public class RunningSumOf1dArray {
    @Test
    public void test001() {
        assert ArrayUtil.dumpInt(new Solution().runningSum(new int[]{1,2,3,4})).equals("[1,3,6,10]");
    }

    @Test
    public void test002() {
        assert ArrayUtil.dumpInt(new Solution().runningSum(new int[]{3,1,2,10,1})).equals("[3,4,6,16,17]");
    }
}
