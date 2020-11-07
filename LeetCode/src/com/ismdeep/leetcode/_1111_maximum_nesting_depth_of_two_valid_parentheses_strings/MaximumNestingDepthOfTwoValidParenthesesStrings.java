package com.ismdeep.leetcode._1111_maximum_nesting_depth_of_two_valid_parentheses_strings;

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
    public int[] maxDepthAfterSplit(String seq) {
        int[] result = new int[seq.length()];
        int val = 0;
        for (int i = 0; i < seq.length(); i++) {
            if (seq.charAt(i) == '(') {
                result[i] = val % 2;
                ++val;
            } else {
                --val;
                result[i] = val % 2;
            }
        }
        return result;
    }
}


public class MaximumNestingDepthOfTwoValidParenthesesStrings {
    @Test
    public void test001() {
        int[] result = new Solution().maxDepthAfterSplit("(()())");
        System.out.println(ArrayUtil.dumpInt(result));
    }

    @Test
    public void test002() {
        int[] result = new Solution().maxDepthAfterSplit("()(())()");
        System.out.println(ArrayUtil.dumpInt(result));
    }
}
