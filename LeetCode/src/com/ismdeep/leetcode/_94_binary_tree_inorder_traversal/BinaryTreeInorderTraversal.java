package com.ismdeep.leetcode._94_binary_tree_inorder_traversal;

import com.ismdeep.leetcode.util.ListUtil;
import org.junit.Test;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class Solution {

    public static void dfsInorder(List<Integer> results, TreeNode root) {
        if (root == null) {
            return;
        }

        dfsInorder(results, root.left);
        results.add(root.val);
        dfsInorder(results, root.right);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        dfsInorder(results, root);
        return results;
    }
}

public class BinaryTreeInorderTraversal {

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

    @Test
    public void test001() {
        TreeNode root = stringToTreeNode("[1,null,2,3]");
        List<Integer> traversalResults = new Solution().inorderTraversal(root);
        System.out.println(ListUtil.dump(traversalResults));
    }
}
