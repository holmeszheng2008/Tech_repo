package array_linked_list.two_pointers.fast_slow_pointers;

import util.ListNode;

// 142. Linked List Cycle II
public class Solution142 {

    public ListNode detectCycle(ListNode head) {
        boolean hasCycle = false;
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }
        if (!hasCycle) {
            return null;
        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
