package com.ismdeep.leetcode._50_pow;

import org.junit.Test;

class Solution {
    public double myPow(double x, int n) {
        return Math.pow(x, n);
    }
}

public class Pow {
    @Test
    public void test001() {
        System.out.println(new Solution().myPow(2, -2));
    }
}
