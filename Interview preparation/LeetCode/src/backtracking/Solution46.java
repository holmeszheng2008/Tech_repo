package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 46. Permutations
public class Solution46 {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        permute(new LinkedList<>(), nums, used);

        return res;
    }

    private void permute(LinkedList<Integer> path, int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            if (path.size() == nums.length) {
                res.add(new ArrayList<>(path));
            }
            permute(path, nums, used);
            path.removeLast();
            used[i] = false;
        }
    }
}
