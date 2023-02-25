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

class Solution110_attempt1 {
    private boolean isBalanced = true;
    public boolean isBalanced(TreeNode root) {
        getDepth(root);

        return isBalanced;
    }

    private int getDepth(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftDepth = getDepth(root.left);
        if(!isBalanced){
            return 0;
        }
        int rightDepth = getDepth(root.right);
        if(!isBalanced){
            return 0;
        }

        if(Math.abs(leftDepth - rightDepth) > 1){
            isBalanced = false;
            return 0;
        }

        return 1 + Math.max(leftDepth, rightDepth);
    }
}