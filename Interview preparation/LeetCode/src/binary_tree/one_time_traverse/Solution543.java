package binary_tree.one_time_traverse;

// 543. Diameter of Binary Tree
public class Solution543 {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxDiameter;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        int diameter = leftDepth + rightDepth;
        this.maxDiameter = Math.max(this.maxDiameter, diameter);

        return 1 + Math.max(leftDepth, rightDepth);
    }
}
