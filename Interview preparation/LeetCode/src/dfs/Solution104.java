package dfs;
/*
 * 104. Maximum Depth of Binary Tree
 */

import util.TreeNode;

class Solution104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return 1 + (left > right ? left : right);
    }
}
