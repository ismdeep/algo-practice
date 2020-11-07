package com.ismdeep.leetcode._67_add_binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;


class Solution {
    public String addBinary(String a, String b) {
        int len = Math.max(a.length(), b.length()) + 1;
        int[] val = new int[len];
        for (int i = 0; i < a.length(); i++) {
            val[i] += a.charAt(a.length() - i - 1) - '0';
        }
        for (int i = 0; i < b.length(); i++) {
            val[i] += b.charAt(b.length() - i - 1) - '0';
        }

        for (int i = 0; i < len - 1; i++) {
            val[i + 1] += val[i] / 2;
            val[i] %= 2;
        }

        int top = len - 1;
        while (val[top] == 0 && top > 0) {
            --top;
        }

        char[] zero_one = new char[]{'0', '1'};

        StringBuilder sb = new StringBuilder();
        for (int i = top; i >= 0; i--) {
            sb.append(zero_one[val[i]]);
        }

        return sb.toString();
    }
}

public class AddBinary {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new StringReader("1111\n1111"));
        String line;
        while ((line = in.readLine()) != null) {
            String a = line;
            line = in.readLine();
            String b = line;

            String out = (new Solution().addBinary(a, b));

            System.out.print(out);
        }
    }
}