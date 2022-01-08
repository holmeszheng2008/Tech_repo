package array_linked_list.two_pointers.binary_search;

import java.util.Arrays;

// 1011. Capacity To Ship Packages Within D Days
public class Solution1011 {
    private int getDays(int capacity, int[] weights) {
        int days = 1;
        int leftCapacity = capacity;
        for (int weight : weights) {
            if (leftCapacity < weight) {
                days++;
                leftCapacity = capacity - weight;
            } else {
                leftCapacity -= weight;
            }
        }
        return days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int left = Arrays.stream(weights).max().getAsInt();
        int right = Integer.MAX_VALUE;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int res = getDays(mid, weights);
            if (res == days) {
                right = mid;
            } else if (res < days) {
                right = mid;
            } else if (res > days) {
                left = mid + 1;
            }
        }

        return left;
    }
}
