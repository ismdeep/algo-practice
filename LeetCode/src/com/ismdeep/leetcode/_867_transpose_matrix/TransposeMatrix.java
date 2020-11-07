package com.ismdeep.leetcode._867_transpose_matrix;

import com.ismdeep.leetcode.util.ArrayUtil;
import org.junit.Test;

class Solution {
    public int[][] transpose(int[][] A) {
        int[][] ans = new int[A[0].length][A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                ans[j][i] = A[i][j];
            }
        }
        return ans;
    }
}

public class TransposeMatrix {

    @Test
    public void test001() {
        assert ArrayUtil.dumpInt2d(new Solution().transpose(new int[][]{
                {1,2,3},{4,5,6},{7,8,9}
        })).equals("[[1,4,7],[2,5,8],[3,6,9]]");
    }
}