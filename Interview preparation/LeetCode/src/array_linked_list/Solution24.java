package array_linked_list;

import util.ListNode;

// 24. Swap Nodes in Pairs
public class Solution24 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode();
        ListNode firstNode = null;
        ListNode secondNode = null;
        ListNode p = dummyHead;
        for(ListNode node = head; node != null;) {
            if(firstNode == null){
                firstNode = node;
                node = node.next;
            } else {
                secondNode = node;
                node = node.next;
                secondNode.next = firstNode;
                p.next = secondNode;
                p = firstNode;
                p.next = null;

                firstNode = null;
                secondNode = null;
            }
        }

        if(firstNode != null && secondNode == null){
            p.next = firstNode;
        }

        return dummyHead.next;
    }
}
