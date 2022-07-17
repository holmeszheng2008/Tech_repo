package binary_search_tree;

import util.TreeNode;

// 98. Validate Binary Search Tree
public class Solution98 {
    private static class Pair {
        public boolean isBST;
        public long min;
        public long max;

        public Pair(boolean isBST, long min, long max) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
        }
    }
    public boolean isValidBST(TreeNode root) {
        return traverse(root).isBST;
    }
    
    private Pair traverse(TreeNode root) {
        if (root == null) {
            return new Pair(true, Long.MAX_VALUE, Long.MIN_VALUE);
        }
        Pair leftRes = traverse(root.left);
        Pair rightRes = traverse(root.right);
        
        if (leftRes.isBST && rightRes.isBST && leftRes.max < root.val && rightRes.min > root.val) {
            long min = Math.min(leftRes.min, root.val);
            long max = Math.max(rightRes.max, root.val);
            
            return new Pair(true, min, max);
        } else {
            return new Pair(false, 0, 0);
        }
    }
}
