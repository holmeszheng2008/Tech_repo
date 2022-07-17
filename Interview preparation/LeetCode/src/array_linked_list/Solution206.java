package array_linked_list;

import util.ListNode;

// 206. Reverse Linked List
public class Solution206 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p1 = head, p2 = p1.next, p3 = p2.next;
        p1.next = null;
        while (true) {
            p2.next = p1;
            if (p3 == null) {
                break;
            }
            p1 = p2;
            p2 = p3;
            p3 = p3.next;
        }

        return p2;
    }
}
