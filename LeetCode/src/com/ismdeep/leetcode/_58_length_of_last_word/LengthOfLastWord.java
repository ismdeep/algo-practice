package com.ismdeep.leetcode._58_length_of_last_word;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null) {
            return 0;
        }
        s = s.trim();
        if (s.equals("")) {
            return 0;
        }
        if (!s.contains(" ")) {
            return s.length();
        }
        return s.length() - s.lastIndexOf(" ") - 1;
    }
}

public class LengthOfLastWord {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {

            int ret = new Solution().lengthOfLastWord(line);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}