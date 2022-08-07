package array_linked_list;

import util.ListNode;

// 92. Reverse Linked List II
public class Solution92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode preFirst = dummyHead;
        ListNode end = dummyHead;
        for (int i = 0; i < left-1; i++) {
            preFirst = preFirst.next;
        }
        ListNode first = preFirst.next;
        ListNode p1 = first;
        for (int i = 0; i <= right; i++) {
            end = end.next;
        }
        ListNode p2 = p1.next;
        ListNode p3 = p2.next;
        while (p3 != end) {
            p2.next = p1;
            p1 = p2;
            p2 = p3;
            p3 = p3.next;
        }

        p2.next = p1;

        preFirst.next = p2;
        first.next = end;

        return dummyHead.next;
    }
}
