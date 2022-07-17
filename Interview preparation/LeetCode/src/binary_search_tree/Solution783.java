package binary_search_tree;

import util.TreeNode;

// 783. Minimum Distance Between BST Nodes
public class Solution783 {
    private int minDiff = Integer.MAX_VALUE;
    private Integer pre;

    public int minDiffInBST(TreeNode root) {
        traverse(root);
        return minDiff;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        traverse(root.left);
        if (pre != null) {
            int diff = Math.abs(root.val - pre);
            minDiff = Math.min(minDiff, diff);
        }
        pre = root.val;
        traverse(root.right);
    }
}
