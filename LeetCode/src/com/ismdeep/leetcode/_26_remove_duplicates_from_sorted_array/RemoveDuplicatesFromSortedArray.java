package com.ismdeep.leetcode._26_remove_duplicates_from_sorted_array;

import org.junit.Test;

class Solution {
    public int removeDuplicates(int[] nums) {
        int len = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[len - 1]) {
                nums[len] = nums[i];
                len++;
            }
        }
        return len;
    }
}

public class RemoveDuplicatesFromSortedArray {

    @Test
    public void test001() {
        int result = new Solution().removeDuplicates(new int[]{1, 2, 2, 3});
        assert result == 3;
    }
}