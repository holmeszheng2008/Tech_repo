package array_linked_list.two_pointers.fast_slow_pointers;

// 83. Remove Duplicates from Sorted List
class Solution83 {

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

    public ListNode deleteDuplicates(ListNode head) {
        ListNode slow = head, fast = head;
        if (head == null) {
            return null;
        }
        while (fast != null){
            int pre = fast.val;
            if (slow != fast) {
                slow.next = fast;
            }
            slow = fast;
            fast = fast.next;
            while(fast!=null && fast.val == pre) {
                fast = fast.next;
            }
        }
        slow.next = null;

        return head;
    }
}
