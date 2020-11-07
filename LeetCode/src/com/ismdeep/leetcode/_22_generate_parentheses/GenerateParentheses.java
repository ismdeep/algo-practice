package com.ismdeep.leetcode._22_generate_parentheses;

import com.ismdeep.leetcode.util.ListUtil;
import org.junit.Test;

import java.util.List;
import java.util.ArrayList;


class Solution {

    public void dfs(List<String> results, String str, int left, int right) {
        if (left == 0 && right == 0) {
            results.add(str);
            return;
        }

        if (left > 0) {
            dfs(results, str + "(", left - 1, right);
        }

        if (right > 0 && right > left) {
            dfs(results, str + ")", left, right - 1);
        }

    }

    public List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<>();
        dfs(results, "", n, n);
        return results;
    }
}

public class GenerateParentheses {

    @Test
    public void test001() {
        List<String> results = new Solution().generateParenthesis(3);
        System.out.println(ListUtil.dump(results));
    }
}
