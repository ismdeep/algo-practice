package com.ismdeep.leetcode._1470_shuffle_the_array;


import com.ismdeep.leetcode.util.ArrayUtil;
import org.junit.Test;

class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] results = new int[n * 2];
        int index = 0;
        for (int i = 0; i < n; i++) {
            results[index++] = nums[i];
            results[index++] = nums[n + i];
        }
        return results;
    }
}

public class ShuffleTheArray {

    @Test
    public void test001() {
        int[] results = new Solution().shuffle(new int[]{2, 5, 1, 3, 4, 7}, 3);
        System.out.println(ArrayUtil.dumpInt(results));
    }
}

