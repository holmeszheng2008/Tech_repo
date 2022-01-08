package array_linked_list.two_pointers.binary_search;

// 875. Koko Eating Bananas
public class Solution875 {
    private int getHours(int kPerHour, int[] piles) {
        int hours = 0;
        for (int i : piles) {
            hours += Math.ceil(((double) piles[i]) / kPerHour);
        }
        return hours;
    }

    // Recursion version
    private int getMinEatingSpeed(int[] piles, int left, int right, int target) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            int ans = getHours(mid, piles);
            if (ans == target) {
                right = mid;
            } else if (ans > target) {
                left = mid + 1;
            } else if (ans < target) {
                right = mid;
            }
            getMinEatingSpeed(piles, left, right, target);
        }

        return left;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int right = 1000000000 + 1;
        return getMinEatingSpeed(piles, 1, right, h);
    }
}