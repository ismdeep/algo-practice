package com.ismdeep.leetcode._48_rotate_image;

import com.ismdeep.leetcode.util.ArrayUtil;
import org.junit.Test;

class Solution {
    public void rotate(int[][] matrix) {
        int tmp;
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int x1, y1, x2, y2, x3, y3, x4, y4;
                x1 = i;
                y1 = j;
                x2 = y1;
                y2 = n - x1 - 1;
                x3 = y2;
                y3 = n - x2 - 1;
                x4 = y3;
                y4 = n - x3 - 1;

                tmp = matrix[x1][y1];
                matrix[x1][y1] = matrix[x4][y4];
                matrix[x4][y4] = matrix[x3][y3];
                matrix[x3][y3] = matrix[x2][y2];
                matrix[x2][y2] = tmp;
            }
        }
    }
}

public class RotateImage {
    @Test
    public void test001() {
        int[][] matrix = new int[][]{
                {1,2,3},{4,5,6},{7,8,9}
        };
        new Solution().rotate(matrix);
        System.out.println(ArrayUtil.dumpInt2d(matrix));
    }
}