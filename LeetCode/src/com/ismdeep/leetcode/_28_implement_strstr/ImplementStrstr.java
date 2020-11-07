package com.ismdeep.leetcode._28_implement_strstr;

import org.junit.Test;


class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.equals("")) {
            return 0;
        }
        return haystack.indexOf(needle);
    }
}

public class ImplementStrstr {
    @Test
    public void test001() {
        assert new Solution().strStr("hello", "ll") == 2;
    }
}