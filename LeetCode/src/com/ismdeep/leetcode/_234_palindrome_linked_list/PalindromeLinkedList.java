package com.ismdeep.leetcode._234_palindrome_linked_list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


class Solution {

    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            list.add(current.val);
            current = current.next;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).equals(list.get(list.size() - i - 1))) {
                return false;
            }
        }
        return true;
    }
}

public class PalindromeLinkedList {

    public static ListNode buildList(int[] nodeValues) {
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for (int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    @Test
    public void test001() {
        assert new Solution().isPalindrome(buildList(new int[]{1, 2, 1}));
    }

    @Test
    public void test002() {
        assert !new Solution().isPalindrome(buildList(new int[]{1, 2, 2}));
    }


}