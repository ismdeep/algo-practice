package com.ismdeep.leetcode._21_merge_two_sorted_lists;

import com.ismdeep.leetcode.util.ArrayUtil;
import org.junit.Test;


class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode merged = new ListNode();
        ListNode tail = merged;
        ListNode cursor1 = l1;
        ListNode cursor2 = l2;

        while (cursor1 != null && cursor2 != null) {
            if (cursor1.val < cursor2.val) {
                tail.next = new ListNode(cursor1.val);
                cursor1 = cursor1.next;
            } else {
                tail.next = new ListNode(cursor2.val);
                cursor2 = cursor2.next;
            }
            tail = tail.next;
        }

        while (cursor1 != null) {
            tail.next = new ListNode(cursor1.val);
            cursor1 = cursor1.next;
            tail = tail.next;
        }

        while (cursor2 != null) {
            tail.next = new ListNode(cursor2.val);
            cursor2 = cursor2.next;
            tail = tail.next;
        }

        return merged.next;
    }
}

public class MergeTwoSortedLists {

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = ArrayUtil.parseIntArr(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        StringBuilder result = new StringBuilder();
        while (node != null) {
            result.append(Integer.toString(node.val)).append(", ");
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    @Test
    public void test001() {
        ListNode l1 = stringToListNode("[1,2,4]");
        ListNode l2 = stringToListNode("[1,3,4]");
        ListNode ret = new Solution().mergeTwoLists(l1, l2);
        String out = listNodeToString(ret);
        System.out.println(out);
    }
}
