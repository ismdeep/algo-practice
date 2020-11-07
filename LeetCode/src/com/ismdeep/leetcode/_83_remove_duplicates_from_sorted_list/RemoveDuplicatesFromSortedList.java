package com.ismdeep.leetcode._83_remove_duplicates_from_sorted_list;

import com.ismdeep.leetcode.util.ArrayUtil;
import org.junit.Test;

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode current = head;
        ListNode cursor = head.next;
        while (cursor != null) {
            if (cursor.val != current.val) {
                current = cursor;
                cursor = cursor.next;
            } else {
                cursor = cursor.next;
                current.next = cursor;
            }
        }
        return head;
    }
}

public class RemoveDuplicatesFromSortedList {

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = ArrayUtil.parseIntArr(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for (int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
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

    @Test
    public void test001() {
        ListNode head = stringToListNode("[1,1,2]");
        ListNode ret = new Solution().deleteDuplicates(head);
        String out = listNodeToString(ret);
        System.out.print(out);
    }
}
