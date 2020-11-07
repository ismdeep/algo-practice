package N78_ReverseList;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public ListNode ReverseList(ListNode head) {
        if (head == null) return null;

        List<ListNode> nodes = new ArrayList<>();
        ListNode cursor = head;
        while (cursor != null) {
            nodes.add(cursor);
            cursor = cursor.next;
        }

        ListNode reversedHead = new ListNode(nodes.get(nodes.size() - 1).val);
        cursor = reversedHead;
        for (int i = nodes.size() - 2; i >= 0; i--) {
            cursor.next = new ListNode(nodes.get(i).val);
            cursor = cursor.next;
        }

        return reversedHead;
    }
}