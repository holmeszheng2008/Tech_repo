package array_linked_list.two_pointers.binary_search;

import java.util.Arrays;

// 1011. Capacity To Ship Packages Within D Days
public class Solution1011 {
    private int getDays(int capacity, int[] weights) {
        int days = 0;
        int currentCapacity = capacity;
        for (int i = 0; i < weights.length;) {
            while (i < weights.length) {
                if (currentCapacity < weights[i]) {
                    currentCapacity = capacity;
                    break;
                } else {
                    currentCapacity -= weights[i];
                }
                i++;
            }

            days++;
        }

        return days;
    }

    public int shipWithinDays(int[] weights, int days) {
        int left = Arrays.stream(weights).max().getAsInt(), right = Integer.MAX_VALUE;
        
        while(left <= right) {
            int mid = left + (right-left)/2;
            int y = getDays(mid, weights);
            if (y == days) {
                right = mid - 1;
            } else if (y > days) {
                left = mid + 1;
            } else if (y < days) {
                right = mid - 1;
            }
        }

        return left;
    }

}