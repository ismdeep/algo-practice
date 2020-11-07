package com.ismdeep.leetcode._202_happy_number;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

class Solution {

    public static int happyCal(int n) {
        int val = 0;
        int tmp;
        while (n != 0) {
            tmp = n % 10;
            val += tmp * tmp;
            n /= 10;
        }
        return val;
    }

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        while (true) {
            n = happyCal(n);
            if (n == 1) {
                return true;
            }
            if (set.contains(n)) {
                return false;
            }
            set.add(n);
        }
    }
}

public class HappyNumber {
    @Test
    public void test001() {
        assert new Solution().isHappy(19);
    }
}