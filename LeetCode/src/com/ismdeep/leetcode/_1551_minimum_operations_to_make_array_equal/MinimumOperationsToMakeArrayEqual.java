package com.ismdeep.leetcode._1551_minimum_operations_to_make_array_equal;

import org.junit.Test;

class Solution {
    public int minOperations(int n) {
        int left = n / 2;
        return n * left - left * left;
    }
}

public class MinimumOperationsToMakeArrayEqual {

    @Test
    public void test001() {
        assert new Solution().minOperations(3) == 2;
    }

    @Test
    public void test002() {
        assert new Solution().minOperations(6) == 9;
    }

}
