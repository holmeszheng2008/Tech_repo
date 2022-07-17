package binary_tree.divide_and_conquer;

import util.TreeNode;

// 110. Balanced Binary Tree
// divide and conquer + global variable
public class Solution110 {
    private boolean isBalanced = true;
    public boolean isBalanced(TreeNode root) {
        getMaxDepth(root);

        return isBalanced;
    }
    private int getMaxDepth(TreeNode root) {
        if (!isBalanced) {
            return 666;
        }
        if (root == null) {
            return 0;
        }
        int left = getMaxDepth(root.left);
        int right = getMaxDepth(root.right);

        if (Math.abs(left - right) > 1) {
            isBalanced = false;
        }

        return 1 + Math.max(left, right);
    }
}
