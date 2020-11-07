package com.ismdeep.leetcode._lcp_._19_UlBDOe_;

import org.junit.Test;

class Solution {
    public int minimumOperations(String leaves) {
        int n = leaves.length();
        int[][] f = new int[n][3];
        f[0][0] = leaves.charAt(0) == 'y' ? 1 : 0;
        f[0][1] = f[0][2] = f[1][2] = Integer.MAX_VALUE;
        for (int i = 1; i < n; ++i) {
            int isRed = leaves.charAt(i) == 'r' ? 1 : 0;
            int isYellow = leaves.charAt(i) == 'y' ? 1 : 0;
            f[i][0] = f[i - 1][0] + isYellow;
            f[i][1] = Math.min(f[i - 1][0], f[i - 1][1]) + isRed;
            if (i >= 2) {
                f[i][2] = Math.min(f[i - 1][1], f[i - 1][2]) + isYellow;
            }
        }
        return f[n - 1][2];
    }
}

public class UlBDOe {
    @Test
    public void test001() {
        assert new Solution().minimumOperations("rrryyyrryyyrr") == 2;
    }

    @Test
    public void test002() {
        assert new Solution().minimumOperations("ryr") == 0;
    }
}
