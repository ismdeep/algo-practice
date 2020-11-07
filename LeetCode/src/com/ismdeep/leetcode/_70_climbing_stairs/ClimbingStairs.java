package com.ismdeep.leetcode._70_climbing_stairs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

class Solution {
    public int climbStairs(int n) {
        if (0 == n) return 0;
        if (1 == n) return 1;
        if (2 == n) return 2;

        int a = 1;
        int b = 2;
        int t;

        for (int i = 3; i <= n; i++) {
            t = a + b;
            a = b;
            b = t;
        }

        return b;
    }
}

public class ClimbingStairs {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new StringReader("4"));
        String line;
        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line);

            int ret = new Solution().climbStairs(n);

            String out = String.valueOf(ret);

            System.out.println(out);
        }
    }
}