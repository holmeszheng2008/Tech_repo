package binary_tree.divide_and_conquer;

import util.TreeNode;

// 1123. Lowest Common Ancestor of Deepest Leaves
public class Solution1123 {

    private TreeNode lca;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        int depth = getDepth(root);
        traverse(root, depth);

        return lca;
    }

    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);

        return 1 + Math.max(left, right);
    }

    private int traverse(TreeNode root, int depth) {
        if (root == null) {
            return 0;
        }

        int left = traverse(root.left, depth - 1);
        int right = traverse(root.right, depth - 1);
        if (left == right && left + 1 == depth) {
            lca = root;
        }

        return 1 + Math.max(left, right);
    }

}
