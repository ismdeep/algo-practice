package com.ismdeep.leetcode._17_letter_combinations_of_a_phone_number;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public final static String[] maps = {
            "", "", "abc", "def",
            "ghi", "jkl", "mno",
            "pqrs", "tuv", "wxyz"
    };

    public void dfs(String digits, int index, String lastStr, List<String> list) {
        if (index >= digits.length()) {
            return;
        }

        int digit = digits.charAt(index) - '0';

        String nextStr;

        for (int i = 0; i < maps[digit].length(); i++) {
            nextStr = lastStr + maps[digit].charAt(i);
            if (index == digits.length() - 1) {
                list.add(nextStr);
            } else {
                dfs(digits, index + 1, nextStr, list);
            }
        }

    }

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();

        dfs(digits, 0, "", list);

        return list;
    }
}

public class LetterCombinationsOfAPhoneNumber {

    @Test
    public void test001() {
        List<String> ret = new Solution().letterCombinations("23");
        System.out.println(ret);
    }
}