package com.ismdeep.leetcode._offer_._3_find_repeat_number;

import org.junit.Test;


class Solution {
    public int findRepeatNumber(int[] nums) {
        boolean[] used = new boolean[nums.length];
        for (int num : nums) {
            if (used[num]) {
                return num;
            }
            used[num] = true;
        }
        return 0;
    }
}

public class FindRepeatNumber {

    @Test
    public void test001() {
        assert new Solution().findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}) == 2;
    }
}