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
        ListNode head = null, current = null;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                if (head == null) {
                    head = list1;
                    current = list1;
                } else {
                    current.next = list1;
                    current = current.next;
                }
                list1 = list1.next;
            } else {
                if (head == null) {
                    head = list2;
                    current = list2;
                } else {
                    current.next = list2;
                    current = current.next;
                }
                list2 = list2.next;
            }
        }
        if (list1 == null) {
            if (head == null) {
                return list2;
            }
            current.next = list2;
        } else {
            if (head == null) {
                return list1;
            }
            current.next = list1;
        }
        return head;
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
