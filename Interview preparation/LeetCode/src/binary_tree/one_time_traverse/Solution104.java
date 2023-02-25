package binary_tree.one_time_traverse;

import util.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Solution104 {
    List<Integer> res = new LinkedList<>();

    List<Integer> preorderTraverse(TreeNode root) {
        traverse(root);
        return res;
    }

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        traverse(root.left);
        traverse(root.right);
    }
}

// Traverse
class Solution104_attempt1 {
    private int maxDepth;
    private int depth;
    public int maxDepth(TreeNode root) {
        dfs(root);

        return maxDepth;
    }

    private void dfs(TreeNode root){
        if(root == null){
            return;
        }
        depth++;
        maxDepth = Math.max(maxDepth, depth);

        dfs(root.left);
        dfs(root.right);

        depth--;
    }
}

// divide
class Solution104_attempt2 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return 1 + Math.max(left, right);
    }
}