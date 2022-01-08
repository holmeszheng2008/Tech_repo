package array_linked_list.two_pointers.left_right_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 3Sum
class Solution55 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n - 2;) {
            int a = nums[i];
            int balance = 0 - a;
            int j = i + 1, k = n - 1;
            while (j < k) {
                if (nums[j] + nums[k] < balance) {
                    j++;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                } else if (nums[j] + nums[k] > balance) {
                    k--;
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                } else {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                }
            }
            i++;
            while (i < n - 2 && nums[i] == nums[i - 1]) {
                i++;
            }
        }
        return result;
    }
}