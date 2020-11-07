package com.ismdeep.leetcode._106_construct_binary_tree_from_inorder_and_postorder_traversal;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public static int[] listToArr(List<Integer> list) {
        if (list.size() <= 0) {
            return new int[]{};
        }

        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }

        return arr;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length <= 0) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postorder.length - 1]);

        List<Integer> leftInorderList = new ArrayList<>();
        List<Integer> leftPostorderList = new ArrayList<>();
        List<Integer> rightInorderList = new ArrayList<>();
        List<Integer> rightPostorderList = new ArrayList<>();

        boolean left = true;
        int i = 0;
        for (int val : inorder) {
            if (val == root.val) {
                left = false;
                continue;
            }

            if (left) {
                leftInorderList.add(val);
                leftPostorderList.add(postorder[i]);
            } else {
                rightInorderList.add(val);
                rightPostorderList.add(postorder[i]);
            }
            i++;
        }

        if (leftInorderList.size() > 0) {
            root.left = buildTree(listToArr(leftInorderList), listToArr(leftPostorderList));
        }

        if (rightInorderList.size() > 0) {
            root.right = buildTree(listToArr(rightInorderList), listToArr(rightPostorderList));
        }

        return root;
    }
}

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    @Test
    public void test001() {
        TreeNode root = new Solution().buildTree(
                new int[]{9, 3, 15, 20, 7},
                new int[]{9, 15, 7, 20, 3}
        );
        assert root.val == 3;
        assert root.left.val == 9;
        assert root.right.val == 20;
        assert root.right.left.val == 15;
        assert root.right.right.val == 7;
    }
}
