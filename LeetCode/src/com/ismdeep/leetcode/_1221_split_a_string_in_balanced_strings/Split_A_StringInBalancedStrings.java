package com.ismdeep.leetcode._1221_split_a_string_in_balanced_strings;

import org.junit.Test;

class Solution {
    public int balancedStringSplit(String s) {
        if (s.equals("")) {
            return 0;
        }

        int l = 0;
        int r = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                ++l;
            } else {
                ++r;
            }
            if (l == r) {
                break;
            }
        }

        return 1 + balancedStringSplit(s.substring(l + r));
    }
}

public class Split_A_StringInBalancedStrings {

    @Test
    public void test001() {
        assert new Solution().balancedStringSplit("RLRRLLRLRL") == 4;
    }

    @Test
    public void test002() {
        assert new Solution().balancedStringSplit("RLLLLRRRLR") == 3;
    }

    @Test
    public void test003() {
        assert new Solution().balancedStringSplit("LLLLRRRR") == 1;
    }

    @Test
    public void test004() {
        assert new Solution().balancedStringSplit("RLRRRLLRLL") == 2;
    }

}
