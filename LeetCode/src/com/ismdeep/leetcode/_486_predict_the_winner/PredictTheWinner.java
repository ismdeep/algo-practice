package com.ismdeep.leetcode._486_predict_the_winner;

import com.ismdeep.leetcode.util.ReaderUtil;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;

class Solution {

    static class PairValue {
        public int a;
        public int b;

        public PairValue(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public void setValue(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;

        PairValue[][] data = new PairValue[n][n];

        for (int i = 0; i < n; i++) {
            data[i][i] = new PairValue(nums[i], 0);
        }

        for (int len = 1; len < n; len++) {
            for (int left = 0; left < n - len; left++) {
                int right = left + len;
                int leftDis = data[left + 1][right].b + nums[left] - data[left + 1][right].a;
                int rightDis = data[left][right - 1].b + nums[right] - data[left][right - 1].a;
                if (leftDis >= rightDis) {
                    data[left][right] = new PairValue(data[left + 1][right].b + nums[left], data[left + 1][right].a);
                } else {
                    data[left][right] = new PairValue(data[left][right - 1].b + nums[right], data[left][right - 1].a);
                }
            }
        }

        return data[0][nums.length - 1].a >= data[0][nums.length - 1].b;
    }
}

public class PredictTheWinner {
    @Test
    public void test001() {
        assert !new Solution().PredictTheWinner(new int[]{1,5,2});
    }

    @Test
    public void test002() {
        assert new Solution().PredictTheWinner(new int[]{1, 5, 233, 7});
    }
}