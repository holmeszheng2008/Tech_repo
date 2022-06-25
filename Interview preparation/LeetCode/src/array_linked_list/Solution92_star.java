package array_linked_list;

// 92. Reverse Linked List II
public class Solution92_star {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseBetween_bk(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode first = dummy;
        dummy.next = head;
        ListNode p1 = head;
        for (int i = 1; i < left; i++) {
            first = p1;
            p1 = p1.next;
        }
        ListNode last = p1;
        ListNode p2 = p1.next, p3 = p2.next;
        while (true) {
            p2.next = p1;
            if (left == right - 1) {
                break;
            }
            left++;
            p1 = p2;
            p2 = p3;
            p3 = p3.next;
        }
        first.next = p2;
        last.next = p3;

        return dummy.next;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode pre = dummyHead;
        for (int i = 1; i < left; i++) {
            pre = pre.next;
        }

        ListNode p1 = pre.next;
        ListNode p2 = p1.next, p3 = p2.next;
        for (; left < right; left++) {
            if (left == right - 1) {
                p2.next = p1;
                break;
            }
            p2.next = p1;
            p1 = p2;
            p2 = p3;
            p3 = p3.next;
        }

        pre.next.next = p3;
        pre.next = p2;

        return dummyHead.next;
    }
}
