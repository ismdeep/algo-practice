package com.ismdeep.leetcode._offer_._6_print_linked_list_from_tail_to_head;

import com.ismdeep.leetcode.util.ArrayUtil;
import org.junit.Test;

import java.util.List;
import java.util.ArrayList;


class Solution {
    public int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode cursor = head;
        while (cursor != null) {
            list.add(cursor.val);
            cursor = cursor.next;
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(list.size() - i - 1);
        }
        return ans;
    }
}

public class PrintLinkedListFromTailToHead {

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

    @Test
    public void test001() {
        ListNode head = stringToListNode("[1,3,2]");
        int[] ret = new Solution().reversePrint(head);
        System.out.println(ArrayUtil.dumpInt(ret));
    }
}