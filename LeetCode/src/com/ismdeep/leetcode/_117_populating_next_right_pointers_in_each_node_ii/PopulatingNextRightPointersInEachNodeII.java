package com.ismdeep.leetcode._117_populating_next_right_pointers_in_each_node_ii;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() { }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        List<Node> nodes = new ArrayList<>();
        nodes.add(root);

        while (nodes.size() > 0) {
            List<Node> nextNodes = new ArrayList<>();
            for (int i = 0; i < nodes.size(); i++) {
                Node cursorNode = nodes.get(i);
                if (i < nodes.size() - 1) {
                    cursorNode.next = nodes.get(i+1);
                }
                if (cursorNode.left != null) {
                    nextNodes.add(cursorNode.left);

                }
                if (cursorNode.right != null) {
                    nextNodes.add(cursorNode.right);
                }
            }
            nodes = new ArrayList<>(nextNodes);
        }

        return root;
    }
}

public class PopulatingNextRightPointersInEachNodeII {

    public static Node __(int val) {
        return new Node(val);
    }

    public static Node __(int val, Node l, Node r) {
        Node node = new Node(val);
        node.left = l;
        node.right = r;
        return node;
    }

    @Test
    public void test001() {
        Node root =
                __(1,
                        __(2,
                                __(4),
                                __(5)),
                        __(3,
                                null,
                                __(7)));
        Node result = new Solution().connect(root);
    }
}
