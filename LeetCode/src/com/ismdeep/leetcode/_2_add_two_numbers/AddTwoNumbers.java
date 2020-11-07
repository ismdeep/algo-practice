package com.ismdeep.leetcode._2_add_two_numbers;

import com.ismdeep.leetcode.util.ArrayUtil;
import org.junit.Test;


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode parseListNode(String digitals) {
        if (digitals.length() <= 0) {
            return null;
        }
        return new ListNode(digitals.charAt(0) - '0', parseListNode(digitals.substring(1)));
    }

    @Override
    public String toString() {
        return String.format("%d %s", val, next != null ? next.toString() : "NULL");
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = new ListNode(0);
        ListNode cursorSum = sum;
        ListNode cursor1 = l1;
        ListNode cursor2 = l2;
        int remain = 0;
        while (cursor1 != null || cursor2 != null) {
            if (cursor1 != null) {
                remain += cursor1.val;
                cursor1 = cursor1.next;
            }
            if (cursor2 != null) {
                remain += cursor2.val;
                cursor2 = cursor2.next;
            }
            cursorSum.val = remain % 10;
            remain /= 10;
            if (remain > 0 || (cursor1 != null || cursor2 != null)) {
                cursorSum.next = new ListNode(0);
                cursorSum = cursorSum.next;
            }
        }
        while (remain > 0) {
            cursorSum.val = remain % 10;
            remain /= 10;
            if (remain > 0) {
                cursorSum.next = new ListNode(0);
            }
        }
        return sum;
    }
}

public class AddTwoNumbers {
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
        ListNode l1 = stringToListNode("[2, 4, 3]");
        ListNode l2 = stringToListNode("[5, 6, 4]");
        ListNode ret = new Solution().addTwoNumbers(l1, l2);

        String out = listNodeToString(ret);

        System.out.print(out);
    }
}