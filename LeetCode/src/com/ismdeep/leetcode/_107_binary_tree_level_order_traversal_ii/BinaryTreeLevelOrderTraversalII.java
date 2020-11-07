package com.ismdeep.leetcode._107_binary_tree_level_order_traversal_ii;

import com.ismdeep.leetcode.util.ListUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {

    public static void bfs(List<List<Integer>> results, List<TreeNode> nodes) {

        if (nodes.size() <= 0) {
            return;
        }

        List<Integer> levelNodes = new ArrayList<>();
        List<TreeNode> nextLevelNodes = new ArrayList<>();
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).left != null) {
                nextLevelNodes.add(nodes.get(i).left);
            }
            if (nodes.get(i).right != null) {
                nextLevelNodes.add(nodes.get(i).right);
            }
            levelNodes.add(nodes.get(i).val);
        }


        bfs(results, nextLevelNodes);

        results.add(levelNodes);
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if (root == null) {
            return results;
        }
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);

        bfs(results, nodes);

        return results;
    }
}

public class BinaryTreeLevelOrderTraversalII {
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
        while(!nodeQueue.isEmpty()) {
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

    @Test
    public void test001() {
        assert ListUtil.dump(new Solution().levelOrderBottom(stringToTreeNode("[]"))).equals("[]");
    }
}