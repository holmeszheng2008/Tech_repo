package array_linked_list;

import util.ListNode;

// 25. Reverse Nodes in k-Group
public class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        int size = 0;
        for(ListNode p = head; p != null; p = p.next){
            size++;
        }
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;
        ListNode tempHead = new ListNode();

        int lastReverse = k * (size / k);
        int current = 1;

        for(ListNode p = head; p != null; current++){
            if(current > lastReverse){
                tail.next = p;
                break;
            } else {
                ListNode oldPNext = p.next;
                p.next = tempHead.next;
                tempHead.next = p;
                if(current % k == 0){
                    tail.next = tempHead.next;
                    for(; tail.next != null; tail = tail.next){

                    }
                    tempHead.next = null;
                }

                p = oldPNext;
            }
        }

        return dummyHead.next;
    }
}
