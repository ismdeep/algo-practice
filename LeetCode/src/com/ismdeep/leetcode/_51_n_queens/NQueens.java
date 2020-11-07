package com.ismdeep.leetcode._51_n_queens;

import com.ismdeep.leetcode.util.ListUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;


class Solution {

    public static List<String> boardToMap(int[][] board) {
        int n = board.length;
        List<String> map = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            map.add(sb.toString());
        }
        return map;
    }

    public static void dfs(List<List<String>> maps, int[][] board, int level) {
        int n = board.length;
        if (level == n) {
            maps.add(boardToMap(board));
            return;
        }

        for (int i = 0; i < n; i++) {
            board[level][i] = 1;
            boolean valid = true;

            // >>>> validate start
            for (int levelId = 0; levelId < level; levelId++) {
                if (board[levelId][i] == 1) {
                    valid = false;
                }
                int left = i - (level - levelId);
                int right = i + (level - levelId);

                if (left >= 0 && board[levelId][left] == 1) {
                    valid = false;
                }
                if (right < n && board[levelId][right] == 1) {
                    valid = false;
                }
            }
            // <<<< validate end

            if (valid) {
                dfs(maps, board, level + 1);
            }
            board[level][i] = 0;
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> maps = new ArrayList<>();
        int[][] board = new int[n][n];
        dfs(maps, board, 0);
        return maps;
    }
}

public class NQueens {
    public static void main(String[] args) {
        List<List<String>> maps = new Solution().solveNQueens(4);
        for (List<String> map : maps) {
            for (String line : map) {
                System.out.println(line);
            }
            System.out.println();
        }
    }
}
