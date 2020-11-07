package com.ismdeep.leetcode._557_reverse_words_in_a_string_iii;

import org.junit.Test;

class Solution {

    public static String reverseWord(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(s.length() - i - 1));
        }
        return sb.toString();
    }

    public String reverseWords(String s) {
        String[] words = s.split(" ");
        String[] reversedWords = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            reversedWords[i] = reverseWord(words[i]);
        }
        return String.join(" ", reversedWords);
    }
}

public class ReverseWordsInAStringIII {
    @Test
    public void test001() {
        assert new Solution().reverseWords("Let's take LeetCode contest").equals("s'teL ekat edoCteeL tsetnoc");
    }
}