package com.ismdeep.leetcode._79_word_search;

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

    public static int[][] dirs = new int[][]{
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };

    public boolean dfs(char[][] board, boolean[][] visited, int x, int y, String word) {
        int n = board.length;
        int m = board[0].length;
        if (x < 0 || x >= n || y < 0 || y >= m) {
            return false;
        }

        if (word.length() == 0) {
            return true;
        }

        if (visited[x][y]) {
            return false;
        }

        if (board[x][y] != word.charAt(0)) {
            return false;
        }

        if (word.length() == 1) {
            return true;
        }

        visited[x][y] = true;

        for (int dirId = 0; dirId < 4; dirId++) {
            int xx = x + dirs[dirId][0];
            int yy = y + dirs[dirId][1];
            if (dfs(board, visited, xx, yy, word.substring(1))) {
                return true;
            }
        }

        visited[x][y] = false;

        return false;
    }

    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                boolean flag = dfs(board, visited, i, j, word);
                if (flag) {
                    return true;
                }
            }
        }

        return false;
    }
}

public class WordSearch {

    @Test
    public void test001() {
        assert new Solution().exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "ABCCED");
    }

    @Test
    public void test002() {
        assert !new Solution().exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "ABCB");
    }

}
