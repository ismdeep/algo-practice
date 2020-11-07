package com.ismdeep.leetcode._501_find_mode_in_binary_search_tree;

import com.ismdeep.leetcode.util.ArrayUtil;
import org.junit.Test;

import java.util.*;

class Solution {

    private Map<Integer, Integer> cntMap;
    private int maxCntVal;

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        if (!cntMap.containsKey(root.val)) {
            cntMap.put(root.val, 0);
        }
        cntMap.put(root.val, cntMap.get(root.val) + 1);
        if (cntMap.get(root.val) > maxCntVal) {
            maxCntVal = cntMap.get(root.val);
        }
        dfs(root.left);
        dfs(root.right);
    }

    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }

        cntMap = new HashMap<>();
        maxCntVal = 0;
        dfs(root);
        List<Integer> resultList = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : cntMap.entrySet()) {
            if (entry.getValue() == maxCntVal) {
                resultList.add(entry.getKey());
            }
        }

        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }
}


public class FindModeInBinarySearchTree {
    @Test
    public void test001() {
        TreeNode root = new TreeNode(
                1,
                null,
                new TreeNode(
                        2,
                        new TreeNode(2),
                        null));
        int[] result = new Solution().findMode(root);
        Arrays.sort(result);
        assert ArrayUtil.dumpInt(result).equals("[2]");
    }
}
