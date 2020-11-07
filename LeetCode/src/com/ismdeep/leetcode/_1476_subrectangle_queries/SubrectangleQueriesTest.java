package com.ismdeep.leetcode._1476_subrectangle_queries;

import org.junit.Test;

class SubrectangleQueries {

    private final int[][] data;

    public SubrectangleQueries(int[][] rectangle) {
        this.data = rectangle;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                data[i][j] = newValue;
            }
        }
    }

    public int getValue(int row, int col) {
        return data[row][col];
    }
}

/**
 * Your SubrectangleQueries object will be instantiated and called as such:
 * SubrectangleQueries obj = new SubrectangleQueries(rectangle);
 * obj.updateSubrectangle(row1,col1,row2,col2,newValue);
 * int param_2 = obj.getValue(row,col);
 */

public class SubrectangleQueriesTest {
    @Test
    public void test001() {
        SubrectangleQueries obj = new SubrectangleQueries(new int[][]{
                {1, 1, 1},
                {1, 1, 1}
        });
        assert obj.getValue(0, 1) == 1;
        obj.updateSubrectangle(0, 1, 1, 2, 3);
        assert obj.getValue(1,1) == 3;
    }
}
