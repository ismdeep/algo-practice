package com.ismdeep.leetcode._35_search_insert_position;

import org.junit.Test;

class Solution {
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
            if (nums[i] > target) {
                return i;
            }
        }
        return nums.length;
    }
}

public class SearchInsertPosition {
    @Test
    public void test001() {
        assert new Solution().searchInsert(new int[]{1,3,5,6}, 5) == 2;
    }
}