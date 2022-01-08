package array_linked_list.diff_array;

// Car Pooling
public class Solution1094 {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] diff = new int[1001];
        for (int i = 0; i < trips.length; i++) {
            int val = trips[i][0];
            int low = trips[i][1];
            int high = trips[i][2] - 1;
            increment(diff, low, high, val);
        }
        return check(diff, capacity);
    }

    private void increment(int[] diff, int low, int high, int val) {
        diff[low] += val;
        if (high + 1 < diff.length) {
            diff[high + 1] -= val;
        }
    }

    private boolean check(int[] diff, int capacity) {
        int pre = diff[0];
        if (pre > capacity) {
            return false;
        }
        for (int i = 1; i < diff.length; i++) {
            pre = pre + diff[i];
            if (pre > capacity) {
                return false;
            }
        }
        return true;
    }
}
