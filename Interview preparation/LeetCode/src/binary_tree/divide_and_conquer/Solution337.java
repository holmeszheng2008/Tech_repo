package binary_tree.divide_and_conquer;

import util.TreeNode;

// 337. House Robber III
public class Solution337 {
    public int rob(TreeNode root) {
        int[] res = takeOrNot(root);
        return Math.max(res[0], res[1]);
    }

    private int[] takeOrNot(TreeNode root) {
        if (root == null) {
            return new int[] {0, 0};
        }
        int[] left = takeOrNot(root.left);
        int[] right = takeOrNot(root.right);

        int take = 0;
        take = left[1] + right[1] + root.val;
        int notTake = 0;
        notTake = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        
        return new int[] {take, notTake};
    }
}
