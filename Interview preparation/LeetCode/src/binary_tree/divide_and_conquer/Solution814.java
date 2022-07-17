package binary_tree.divide_and_conquer;

import util.TreeNode;

// 814. Binary Tree Pruning
public class Solution814 {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.left == null && root.right == null && root.val != 1) {
            return null;
        }

        return root;
    }
}
