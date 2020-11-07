package com.ismdeep.leetcode._338_counting_bits;

import com.ismdeep.leetcode.util.ArrayUtil;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.PriorityQueue;

class Solution {

    public static int c(int num) {
        int cnt = 0;
        while (num != 0) {
            cnt += num % 2;
            num /= 2;
        }
        return cnt;
    }

    public int[] countBits(int num) {
        int[] results = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            if (results[i] == 0) {
                results[i] = c(i);
                for (int j = i * 2; j <= num; j *= 2) {
                    results[j] = results[i];
                }
            }
        }
        return results;
    }
}

public class CountingBits {

    @Test
    public void test001() {
        int[] results = new Solution().countBits(2);
        System.out.println(ArrayUtil.dumpInt(results));
    }

    @Test
    public void test002() {
        int[] results = new Solution().countBits(5);
        System.out.println(ArrayUtil.dumpInt(results));
    }
}
