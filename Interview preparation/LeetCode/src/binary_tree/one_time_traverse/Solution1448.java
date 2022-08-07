package binary_tree.one_time_traverse;

import util.TreeNode;

// 1448. Count Good Nodes in Binary Tree
public class Solution1448 {
    private int num;

    public int goodNodes(TreeNode root) {
        traverse(root, Integer.MIN_VALUE);
        return num;
    }

    private void traverse(TreeNode root, int pathMax) {
        if (root == null) {
            return;
        }
        if (root.val >= pathMax) {
            num++;
            pathMax = root.val;
        }
        traverse(root.left, pathMax);
        traverse(root.right, pathMax);
    }
}
