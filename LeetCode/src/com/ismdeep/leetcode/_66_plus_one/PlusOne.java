package com.ismdeep.leetcode._66_plus_one;

import com.ismdeep.leetcode.util.ArrayUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

class Solution {

    public int[] one_zeros(int zeros_cnt) {
        int[] results = new int[zeros_cnt + 1];
        results[0] = 1;
        for (int i = 1; i <= zeros_cnt; i++) {
            results[i] = 0;
        }
        return results;
    }

    public int[] plusOne(int[] digits) {
        boolean nines = true;
        for (int digit : digits) {
            if (digit != 9) {
                nines = false;
                break;
            }
        }
        if (nines) {
            return one_zeros(digits.length);
        }

        int[] results = new int[digits.length];

        System.arraycopy(digits, 0, results, 0, digits.length);

        results[results.length - 1] += 1;

        for (int i = results.length - 1; i >= 1; i--) {
            results[i - 1] += results[i] / 10;
            results[i] %= 10;
        }

        return results;
    }
}

public class PlusOne {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new StringReader("[1,2,3]"));
        String line;
        while ((line = in.readLine()) != null) {
            int[] digits = ArrayUtil.parseIntArr(line);

            int[] ret = new Solution().plusOne(digits);

            String out = ArrayUtil.dumpInt(ret);

            System.out.println(out);
        }
    }
}