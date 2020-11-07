package com.ismdeep.leetcode._38_count_and_say;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {

    public String readOffStr(String str) {
        char ch = '-';
        int cnt = 0;
        String sentence = "";
        for (int i = 0; i < str.length(); i++) {
            if (ch != str.charAt(i)) {
                if (cnt > 0) {
                    sentence = String.format("%s%d%c", sentence, cnt, ch);
                }
                cnt = 0;
            }
            cnt++;
            ch = str.charAt(i);
        }
        sentence = String.format("%s%d%c", sentence, cnt, ch);
        return sentence;
    }

    public String countAndSay(int n) {
        String initStr = "1";
        while (n-- > 1) {
            initStr = readOffStr(initStr);
        }
        return initStr;
    }
}

public class CountAndSay {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line);

            String out = (new Solution().countAndSay(n));

            System.out.print(out);
        }
    }
}