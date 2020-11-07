package com.ismdeep.leetcode._6_zigzag_conversion;

import org.junit.Test;


class Solution {
    public String convert(String s, int numRows) {
        if (1 == numRows) {
            return s;
        }

        StringBuilder sb = new StringBuilder();

        int step = (numRows - 1) * 2;
        for (int i = 0; i < s.length(); i += step) {
            sb.append(s.charAt(i));
        }

        for (int rowId = 1; rowId < numRows - 1; rowId++) {
            int distance = step - rowId * 2;
            for (int i = rowId; i < s.length(); i += step) {
                sb.append(s.charAt(i));
                if (i + distance < s.length()) {
                    sb.append(s.charAt(i + distance));
                }
            }
        }

        for (int i = numRows - 1; i < s.length(); i += step) {
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}

public class ZigzagConversion {
    @Test
    public void test001() {
        String result = new Solution().convert("LEETCODEISHIRING", 4);
        System.out.println(result);
    }

}