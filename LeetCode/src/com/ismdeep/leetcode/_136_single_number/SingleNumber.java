package com.ismdeep.leetcode._136_single_number;

import org.junit.Test;

class Solution {
    public int singleNumber(int[] nums) {
        int val = 0;
        for (int num : nums) {
            val ^= num;
        }
        return val;
    }
}

public class SingleNumber {
    @Test
    public void test001() {
        assert new Solution().singleNumber(new int[]{4,1,2,1,2}) == 4;
    }
}