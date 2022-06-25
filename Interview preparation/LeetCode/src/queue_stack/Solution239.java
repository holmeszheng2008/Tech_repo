package queue_stack;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution239 {
    private class MonotonicQueue {
        private Deque<Integer> deque = new LinkedList<>();

        public void offer(Integer e) {
            while (!deque.isEmpty() && deque.peekLast() < e) {
                deque.pollLast();
            }
            deque.offerLast(e);
        }

        public void remove(Integer e) {
            if (deque.peekFirst().equals(e)) {
                deque.pollFirst();
            }
        }
        public int max() {
            return deque.peekFirst();
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue mq = new MonotonicQueue();
        List<Integer> res = new ArrayList<>();
        int left = 0, right = 0;
        while (right - left < k) {
            mq.offer(nums[right]);
            right++;
        }
        res.add(mq.max());
        while (right < nums.length) {
            int in = nums[right];
            right++;
            mq.offer(in);
            int out = nums[left];
            left++;
            mq.remove(out);
            res.add(mq.max());
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
