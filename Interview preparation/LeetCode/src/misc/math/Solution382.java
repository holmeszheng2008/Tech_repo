package misc.math;

import util.ListNode;

import java.util.Random;

// 382. Linked List Random Node
public class Solution382 {
    private ListNode head;
    private Random random = new Random();
    public Solution382(ListNode head) {
        this.head = head;
    }

    public int getRandom() {
        int res = 0, i = 0;
        for(ListNode p = head; p != null; p = p.next){
            int num = random.nextInt(++i);
            if (num == 0){
                res = p.val;
            }
        }

        return res;
    }
}