package N78_ReverseList;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ReverseList {

    public static List<Integer> linkedListToList(ListNode head) {
        List<Integer> items = new ArrayList<>();
        ListNode cursor = head;
        while (cursor != null) {
            items.add(cursor.val);
            cursor = cursor.next;
        }
        return items;
    }

    @Test
    public void test001() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        ListNode reversed = new Solution().ReverseList(head);
        System.out.println(linkedListToList(reversed));
    }
}
