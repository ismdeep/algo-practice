package com.ismdeep.leetcode._203_remove_linked_list_elements;

import com.ismdeep.leetcode.util.ListUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode ans = head;
        ListNode current = null;
        while (ans != null && ans.val == val) {
            ans = ans.next;
        }

        current = head;
        while (current != null && current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return ans;
    }
}

public class RemoveLinkedListElements {
    public static ListNode buildList(int[] nodeValues) {
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for (int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String listNodeToString(ListNode node) {
        List<Integer> result = new ArrayList<>();
        while (node != null) {
            result.add(node.val);
            node = node.next;
        }
        return ListUtil.dump(result);
    }

    @Test
    public void test001() {
        assert listNodeToString(new Solution().removeElements(buildList(new int[]{1, 2, 6, 3, 4, 5, 6}), 6)).equals("[1,2,3,4,5]");
    }

    @Test
    public void test002() {
        assert listNodeToString(new Solution().removeElements(buildList(new int[]{1, 1}), 1)).equals("[]");
    }

    @Test
    public void test003() {
        assert listNodeToString(new Solution().removeElements(buildList(new int[]{}), 1)).equals("[]");
    }
}