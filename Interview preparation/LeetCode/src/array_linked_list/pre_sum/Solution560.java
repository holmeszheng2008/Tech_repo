package array_linked_list.pre_sum;

import java.util.HashMap;
import java.util.Map;

// 560. Subarray Sum Equals K
// PreSum + 2Sum
public class Solution560 {
    int subarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> preSumOccur = new HashMap<>();
        int preSum = 0, res = 0;
        preSumOccur.put(0, 1);
        for (int i = 0; i < n; i++) {
            preSum = preSum + nums[i];
            int balance = preSum - k;
            res += preSumOccur.getOrDefault(balance, 0);
            preSumOccur.put(preSum, preSumOccur.getOrDefault(preSum, 0) + 1);
        }

        return res;
    }
}


class Solution {
    int subarraySum(int[] nums, int k) {
        int res = 0;
        int n = nums.length;
        int[] preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        // preSum[j] - preSum[i] = k
        Map<Integer, Integer> preSumOccurMap = new HashMap<>();
        preSumOccurMap.put(0, 1);
        for (int i = 1; i < n + 1; i++) {
            int second = preSum[i] - k;
            res += preSumOccurMap.getOrDefault(second, 0);
            preSumOccurMap.put(preSum[i], preSumOccurMap.getOrDefault(preSum[i], 0) + 1);
        }

        return res;
    }
}
