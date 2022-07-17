package array_linked_list;

import java.util.PriorityQueue;
import util.ListNode;

// 23. Merge k Sorted Lists
public class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>((ListNode o1, ListNode o2) -> {
            return o1.val - o2.val;
        });
        ListNode dummyHead = new ListNode();
        ListNode p = dummyHead;
        for (ListNode head : lists) {
            if (head != null) {
                pq.add(head);
            }
        }
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            if (node.next != null) {
                pq.add(node.next);
            }
            p.next = node;
            p = p.next;
        }

        return dummyHead.next;
    }

    public ListNode mergeKLists_better(ListNode[] lists) {
        ListNode head = new ListNode(0), p = head;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((ListNode o1, ListNode o2) -> o1.val - o2.val);
        for (ListNode list : lists) {
            if (list != null) {
                pq.offer(list);
            }
        }
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            p.next = node;
            if (node.next != null) {
                pq.offer(node.next);
            }
            p = p.next;
        }

        return head.next;
    }
    /*
     * 优先队列 pq 中的元素个数最多是 k，所以⼀次 poll 或者 add ⽅法的时间复杂度是 O(logk)；所有的链表 节点都会被加⼊和弹出 pq，所以算法整体的时间复杂度是
     * O(Nlogk)，其中 k 是链表的条数，N 是这些链表 的节点总数。
     */
}
