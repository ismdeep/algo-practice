package com.ismdeep.leetcode._257_binary_tree_paths;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {

    public static String dump(List<Integer> path) {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (Integer item : path) {
            if (!first) {
                sb.append("->");
            }
            first = false;
            sb.append(item);
        }
        return sb.toString();
    }

    public static void dfs(TreeNode current, List<String> paths, List<Integer> path) {

        if (current == null) {
            return;
        }

        path.add(current.val);

        if (current.left == null && current.right == null) {
            paths.add(dump(path));
            path.remove(path.size() - 1);
            return;
        }

        if (current.left != null) {
            dfs(current.left, paths, path);
        }

        if (current.right != null) {
            dfs(current.right, paths, path);
        }

        path.remove(path.size() - 1);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        dfs(root, paths, path);

        return paths;
    }
}

public class BinaryTreePaths {
    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static String stringListToString(List<String> stringList) {
        StringBuilder sb = new StringBuilder("[");
        for (String item : stringList) {
            sb.append(item);
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    @Test
    public void test001() {
        TreeNode root = stringToTreeNode("[1,2,3,null,5]");
        List<String> ret = new Solution().binaryTreePaths(root);
        String out = stringListToString(ret);
        assert out.equals("[1->2->5,1->3]");
    }
}