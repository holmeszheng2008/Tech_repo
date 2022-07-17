package binary_tree.one_time_traverse;

import util.TreeNode;

// 114. Flatten Binary Tree to Linked List
public class Solution114 {
    private TreeNode tail = new TreeNode();

    public void flatten(TreeNode root) {
        traverse(root);
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        tail.right = root;
        tail = root;

        traverse(left);
        traverse(right);
    }
}
