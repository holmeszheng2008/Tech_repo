package array_linked_list.two_pointers.left_right_pointers;

import java.util.Arrays;
import java.util.PriorityQueue;

// 870. Advantage Shuffle
public class Solution870 {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int length = nums1.length;
        int[] result = new int[length];
        Arrays.sort(nums1);
        int left = 0, right = length - 1;
        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] o1, int[] o2) -> o2[1] - o1[1]);
        for (int i = 0; i < length; i++) {
            pq.offer(new int[] {i, nums2[i]});
        }

        while (!pq.isEmpty()) {
            int[] pair = pq.poll();
            if (nums1[right] > pair[1]) {
                result[pair[0]] = nums1[right];
                right--;
            } else {
                result[pair[0]] = nums1[left];
                left++;
            }
        }

        return result;
    }
}
