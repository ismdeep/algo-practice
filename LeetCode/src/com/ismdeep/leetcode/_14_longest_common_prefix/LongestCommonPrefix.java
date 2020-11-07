package com.ismdeep.leetcode._14_longest_common_prefix;

import org.junit.Test;


class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length <= 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        int len = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < len) {
                len = strs[i].length();
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            boolean flag = true;
            for (int strId = 1; strId < strs.length; strId++) {
                if (strs[strId].charAt(i) != strs[0].charAt(i)) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                break;
            }
            sb.append(strs[0].charAt(i));
        }
        return sb.toString();
    }
}

public class LongestCommonPrefix {
    @Test
    public void test001() {
        assert new Solution().longestCommonPrefix(new String[]{"flower", "flow", "flight"}).equals("fl");
    }
}