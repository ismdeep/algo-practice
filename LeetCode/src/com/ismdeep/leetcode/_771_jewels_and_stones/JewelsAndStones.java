package com.ismdeep.leetcode._771_jewels_and_stones;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int numJewelsInStones(String J, String S) {
        Set<Character> jewels = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            jewels.add(J.charAt(i));
        }
        int cnt = 0;
        for (int i = 0; i < S.length(); i++) {
            if (jewels.contains(S.charAt(i))) {
                ++cnt;
            }
        }
        return cnt;
    }
}

public class JewelsAndStones {
    @Test
    public void test001() {
        assert new Solution().numJewelsInStones("aA", "aAAbbbb") == 3;
    }
}
