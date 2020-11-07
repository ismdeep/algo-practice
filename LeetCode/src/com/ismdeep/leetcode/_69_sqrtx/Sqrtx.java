package com.ismdeep.leetcode._69_sqrtx;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int mySqrt(int x) {
        return (int) Math.sqrt(x);
    }
}

public class Sqrtx {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int x = Integer.parseInt(line);

            int ret = new Solution().mySqrt(x);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}