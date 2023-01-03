package backtracking;

import java.util.*;

// 46. Permutations
public class Solution46 {
    private List<List<Integer>> res = new ArrayList<>();
    private Set<Integer> used = new HashSet<>();
    private LinkedList<Integer> path = new LinkedList<>();
    private int[] nums;
    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        backtracking();

        return res;
    }

    private void backtracking(){
        for(int num : nums){
            if(used.contains(num)){
                continue;
            }
            path.add(num);
            used.add(num);

            if(path.size() == nums.length){
                res.add(new ArrayList<>(path));
            } else {
                backtracking();
            }

            path.removeLast();
            used.remove(num);
        }
    }
}
