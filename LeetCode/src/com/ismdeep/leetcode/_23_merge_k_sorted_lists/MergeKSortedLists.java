package com.ismdeep.leetcode._23_merge_k_sorted_lists;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists.length <= 0) {
            return null;
        }

        PriorityQueue<ListNode> headers = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return Integer.compare(o1.val, o2.val);
            }
        });

        for (ListNode list : lists) {
            if (list != null) {
                headers.add(list);
            }
        }

        ListNode merged = null;
        ListNode tail = null;
        if (!headers.isEmpty()) {
            merged = new ListNode();
            ListNode pop = headers.poll();
            merged.val = pop.val;
            tail = merged;
            if (pop.next != null) {
                headers.add(pop.next);
            }
        }

        while (!headers.isEmpty()) {
            ListNode pop = headers.poll();
            ListNode tmp = new ListNode();
            tmp.val = pop.val;
            tail.next = tmp;
            tail = tail.next;
            if (pop.next != null) {
                headers.add(pop.next);
            }
        }

        return merged;
    }
}


public class MergeKSortedLists {

    public static ListNode buildList(int[] nums) {
        ListNode listNode = null;
        ListNode tail = null;

        for (int num : nums) {
            if (listNode == null) {
                listNode = new ListNode();
                listNode.val = num;
                tail = listNode;
            } else {
                ListNode tmp = new ListNode();
                tmp.val = num;
                tail.next = tmp;
                tail = tail.next;
            }
        }

        return listNode;
    }

    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[]{
                buildList(new int[]{1,4,5}),
                buildList(new int[]{1,3,4}),
                buildList(new int[]{2,3})
        };


        ListNode mergedList = new Solution().mergeKLists(lists);

        System.out.println(listNodeToString(mergedList));

    }
}
