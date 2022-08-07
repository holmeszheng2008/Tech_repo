package backtracking.num_selection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 78. Subsets
public class Solution78 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        res.add(new ArrayList<>());
        backtracking(nums, 0, new LinkedList<>());

        return res;
    }

    private void backtracking(int[] nums, int start, LinkedList<Integer> preSet) {
        if (start == nums.length) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            preSet.add(nums[i]);
            res.add(new ArrayList<>(preSet));
            backtracking(nums, i + 1, preSet);
            preSet.removeLast();
        }
    }
}
