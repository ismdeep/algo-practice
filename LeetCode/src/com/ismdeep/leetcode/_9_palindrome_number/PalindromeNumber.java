package com.ismdeep.leetcode._9_palindrome_number;

import com.ismdeep.leetcode.util.ReaderUtil;
import org.junit.Test;

import java.io.*;

class Solution {
    public boolean isPalindrome(int x) {
        String str = Integer.toString(x);

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}

public class PalindromeNumber {
    @Test
    public void test001() {
        assert new Solution().isPalindrome(121);
    }

    @Test
    public void test002() {
        assert !new Solution().isPalindrome(-121);
    }
}