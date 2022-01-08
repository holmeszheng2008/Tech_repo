package binary_tree.one_time_traverse;

import util.TreeNode;

// maxDepth
public class SolutionCus1 {
    private int res = 0;

    public int maxDepth(TreeNode root) {
        int depth = 0;
        traverse(root, depth);
        return res;
    }

    private void traverse(TreeNode root, int depth) {
        if (root == null) {
            res = Math.max(res, depth);
            return;
        }
        depth++;
        traverse(root.left, depth);
        traverse(root.right, depth);
        depth--;
    }
}
