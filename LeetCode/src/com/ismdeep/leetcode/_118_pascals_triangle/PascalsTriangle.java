package com.ismdeep.leetcode._118_pascals_triangle;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static List<Integer> generateNext(List<Integer> items) {
        List<Integer> nextItems = new ArrayList<>();
        for (int i = 0; i <= items.size(); i++) {
            nextItems.add(1);
        }
        for (int i = 1; i < items.size(); i++) {
            nextItems.set(i, items.get(i - 1) + items.get(i));
        }
        return nextItems;
    }

    public List<List<Integer>> generate(int numRows) {
        if (numRows <= 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> items = new ArrayList<>();
        items.add(1);
        result.add(items);
        for (int i = 1; i < numRows; i++) {
            result.add(generateNext(result.get(result.size() - 1)));
        }

        return result;
    }
}

public class PascalsTriangle {
    @Test
    public void test001() {
        List<List<Integer>> result = new Solution().generate(5);
        for (List<Integer> line : result) {
            for (Integer item : line) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }
}
