package backtracking;

import java.util.HashSet;
import java.util.Set;

// 698. Partition to K Equal Sum Subsets
public class Solution698 {
    private boolean res = false;
    private int[] nums;
    private int k;
    private Set<Integer> memo = new HashSet<>();

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        if (k > nums.length) {
            return false;
        }
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
        int target = sum/k;
        this.nums = nums;
        this.k = k;

        backtracking(0, 0, 0, target, 0);

        return res;
    }

    private void backtracking(int bucketI, int preSum, int start, int target, int used) {
        if (res) {
            return;
        }
        if (memo.contains(used)) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (((used >> i) & 1) == 1) {
                continue;
            }
            if (preSum + nums[i] > target) {
                continue;
            }
            used |= 1 << i;
            preSum += nums[i];

            if (preSum == target && bucketI == k - 1) {
                res = true;
                return;
            } else {
                if (preSum == target) {
                    backtracking(bucketI + 1, 0, 0, target, used);
                    memo.add(used);
                } else {
                    backtracking(bucketI, preSum, i + 1, target, used);
                    memo.add(used);
                }
            }

            used &= ~(1 << i);
            preSum -= nums[i];
        }
    }
}
