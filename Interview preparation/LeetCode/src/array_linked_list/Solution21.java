package array_linked_list;

// 21. Merge Two Sorted Lists
public class Solution21 {

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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode current = head;
        while (!(list1 == null && list2 == null)) {
            if (list1 == null) {
                current.next = list2;
                list2 = null;
            } else if (list2 == null) {
                current.next = list1;
                list1 = null;
            } else {
                if (list1.val < list2.val) {
                    current.next = list1;
                    list1 = list1.next;
                    current = current.next;
                } else {
                    current.next = list2;
                    list2 = list2.next;
                    current = current.next;
                }
            }
        }

        return head.next;
    }

    public ListNode mergeTwoListsDummy(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0), p = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                p.next = list1;
                list1 = list1.next;
                p = p.next;
            } else {
                p.next = list2;
                list2 = list2.next;
                p = p.next;
            }
        }
        if (list1 == null) {
            p.next = list2;
        } else {
            p.next = list1;
        }
        return head.next;
    }
}
