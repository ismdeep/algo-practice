package com.ismdeep.leetcode._37_sudoku_solver;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {

    public static List<List<Integer>> relevantPointList(int x, int y) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            if (i != y) {
                list1.add(x * 10 + i);
            }
            if (i != x) {
                list2.add(i * 10 + y);
            }
        }

        List<Integer> list3 = new ArrayList<>();
        int xx = x - x % 3;
        int yy = y - y % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (xx + i != x && yy + j != y) {
                    list3.add((xx + i) * 10 + (yy + j));
                }
            }
        }

        List<List<Integer>> list = new ArrayList<>();
        list.add(list1);
        list.add(list2);
        list.add(list3);
        return list;
    }

    public static boolean dfs(List<Integer> todos, int index, int[][] board, HashMap<Integer, List<List<Integer>>> maps) {

        if (index >= todos.size()) {
            return true;
        }

        boolean[] used = new boolean[10];
        for (int i = 1; i <= 9; i++) {
            used[i] = false;
        }

        List<List<Integer>> relevantList = maps.get(todos.get(index));
        for (List<Integer> relevants : relevantList) {
            for (Integer relevant : relevants) {
                used[board[relevant / 10][relevant % 10]] = true;
            }
        }

        for (int i = 1; i <= 9; i++) {
            if (!used[i]) {
                board[todos.get(index) / 10][todos.get(index) % 10] = i;
                if (dfs(todos, index + 1, board, maps)) {
                    return true;
                }
                board[todos.get(index) / 10][todos.get(index) % 10] = 0;
            }
        }

        return false;
    }

    public void solveSudokuInt(int[][] board) {

        HashMap<Integer, List<List<Integer>>> maps = new HashMap<>();
        List<Integer> todos = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (0 == board[i][j]) {
                    maps.put(i * 10 + j, relevantPointList(i, j));
                    todos.add(i * 10 + j);
                }
            }
        }

        dfs(todos, 0, board, maps);

    }

    public void solveSudoku(char[][] board) {
        int[][] boardInt = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    boardInt[i][j] = 0;
                } else {
                    boardInt[i][j] = board[i][j] - '0';
                }
            }
        }

        solveSudokuInt(boardInt);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (boardInt[i][j] == 0) {
                    board[i][j] = '.';
                } else {
                    board[i][j] = (char) (boardInt[i][j] + '0');
                }
            }
        }

    }
}

public class SudokuSolver {

    public static void printBoard(char[][] board) {

        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0) {
                System.out.println("+-----------------------+");
            }
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0) {
                    System.out.print("| ");
                }
                System.out.print(board[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("+-----------------------+");
        System.out.println();
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        printBoard(board);
        new Solution().solveSudoku(board);
        printBoard(board);
    }
}
