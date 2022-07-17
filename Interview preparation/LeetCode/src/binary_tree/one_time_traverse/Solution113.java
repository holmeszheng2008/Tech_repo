package binary_tree.one_time_traverse;

import java.util.ArrayList;
import java.util.List;
import util.TreeNode;

// 113. Path Sum II
public class Solution113 {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return res;
        }
        traverse(root, 0, new ArrayList<>(), targetSum);

        return res;
    }

    private void traverse(TreeNode root, int preSum, List<Integer> path, int targetSum) {
        if (root == null) {
            return;
        }
        int currentSum = preSum + root.val;
        path.add(root.val);
        if (root.left == null && root.right == null && currentSum == targetSum) {
            res.add(new ArrayList<Integer>(path));
        }
        traverse(root.left, currentSum, path, targetSum);
        traverse(root.right, currentSum, path, targetSum);

        path.remove(path.size() - 1);
    }
}
