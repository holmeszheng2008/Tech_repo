package binary_tree.one_time_traverse;

import util.TreeNode;

// 112. Path Sum
// backtracking
// apply decision made on current level -> deep down to the next level -> revert decision made on current level
public class Solution112 {
    private boolean res = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        traverse(root, 0, targetSum);
        return res;
    }

    private void traverse(TreeNode root, int preSum, int targetSum) {
        if (root == null) {
            return;
        }
        if (res) {
            return;
        }
        preSum += root.val;
        if (root.left == null && root.right == null && preSum == targetSum) {
            res = true;
        }
        traverse(root.left, preSum, targetSum);
        traverse(root.right, preSum, targetSum);
        preSum -= root.val;
    }
}
