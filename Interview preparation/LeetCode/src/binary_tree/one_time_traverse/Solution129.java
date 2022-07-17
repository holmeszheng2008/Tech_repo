package binary_tree.one_time_traverse;

import util.TreeNode;

// 129. Sum Root to Leaf Numbers
public class Solution129 {
    private int currentSum = 0;
    private int sum = 0;

    public int sumNumbers(TreeNode root) {
        traverse(root);
        return sum;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        currentSum = currentSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum += currentSum;
        }
        traverse(root.left);
        traverse(root.right);

        currentSum = (currentSum - root.val) / 10;
    }
}
