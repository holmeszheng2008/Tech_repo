package binary_tree.divide_and_conquer;

import util.TreeNode;

// 1123. Lowest Common Ancestor of Deepest Leaves
public class Solution1123 {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        int maxDepth = maxDepth(root);
        return getLCA(root, 1, maxDepth);
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;

    }

    private TreeNode getLCA(TreeNode root, int currentDepth, int maxDepth) {
        if (root == null) {
            return null;
        }
        if (currentDepth == maxDepth) {
            return root;
        }
        TreeNode leftLCA = getLCA(root.left, currentDepth + 1, maxDepth);
        TreeNode rightLCA = getLCA(root.right, currentDepth + 1, maxDepth);

        if (leftLCA != null) {
            if (rightLCA != null) {
                return root;
            }
            return leftLCA;
        }

        return rightLCA;
    }
}