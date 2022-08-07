package backtracking.num_selection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 39. Combination Sum
public class Solution39 {
    private List<List<Integer>> res = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtracking(candidates, 0, target);

        return res;
    }

    private void backtracking(int[] candidates, int start, int target) {
        for (int i = start; i < candidates.length; i++) {
            if (target < candidates[i]) {
                continue;
            }

            target -= candidates[i];
            path.add(candidates[i]);

            if (target == 0) {
                res.add(new ArrayList<>(path));
            } else {
                backtracking(candidates, i, target);
            }

            target += candidates[i];
            path.removeLast();
        }
    }
}
