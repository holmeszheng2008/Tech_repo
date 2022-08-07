package backtracking.num_selection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// 40. Combination Sum II
public class Solution40 {
    private List<List<Integer>> res = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates, 0, target);

        return res;
    }

    private void backtracking(int[] candidates, int start, int target) {
        for (int i = start; i < candidates.length; i++) {
            if (i - 1 >= start && candidates[i - 1] == candidates[i]) {
                continue;
            }
            if (target - candidates[i] < 0) {
                break;
            }

            target -= candidates[i];
            path.add(candidates[i]);

            if (target == 0) {
                res.add(new ArrayList<>(path));
            } else {
                backtracking(candidates, i + 1, target);
            }

            target += candidates[i];
            path.removeLast();
        }
    }
}
