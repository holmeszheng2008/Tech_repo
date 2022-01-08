package array_linked_list;

// 206. Reverse Linked List
public class Solution206 {

    public class ListNode {
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

    class Solution {
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
}
