package com.ismdeep.leetcode._60_permutation_sequence;

import com.ismdeep.leetcode.util.ReaderUtil;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;

class Solution {

    public static int fact(int n) {
        int val = 1;
        for (int i = 1; i <= n; i++) {
            val *= i;
        }
        return val;
    }

    public static String p(int[] items, int k) {
        int n = items.length;
        if (n <= 0) {
            return "";
        }

        if (n == 1) {
            return Integer.toString(items[0]);
        }

        StringBuilder sb = new StringBuilder();

        int[] nextItems = new int[n - 1];
        int index = 0;
        int excludeIndex = (k - 1) / fact(n - 1);
        sb.append(items[excludeIndex]);
        for (int i = 0; i < n; i++) {
            if (i != excludeIndex) {
                nextItems[index] = items[i];
                index++;
            }
        }

        sb.append(p(nextItems, k - excludeIndex * fact(n - 1)));

        return sb.toString();
    }

    public String getPermutation(int n, int k) {
        int[] items = new int[n];
        for (int i = 0; i < n; i++) {
            items[i] = i + 1;
        }
        return p(items, k);
    }
}

public class PermutationSequence {
    @Test
    public void test001() {
        assert new Solution().getPermutation(4,9).equals("2314");
    }
}