package backtracking.num_selection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// 47. Permutations II
public class Solution47 {
    private List<List<Integer>> res = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backtracking(nums, used);

        return res;
    }

    private void backtracking(int[] nums, boolean[] used) {
        int pre = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == pre) {
                continue;
            }
            if (used[i]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            pre = nums[i];

            if (path.size() == nums.length) {
                res.add(new ArrayList<>(path));
            } else {
                backtracking(nums, used);
            }

            path.removeLast();
            used[i] = false;
        }
    }
}
