package binary_tree.bfs;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

// 111. Minimum Depth of Binary Tree
public class Solution111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            depth++;
        }

        return -1;
    }
}

class Solution111_attempt1 {
    private int depth;
    private int minDepth = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        dfs(root);

        return minDepth;
    }

    private void dfs(TreeNode root){
        if(root == null){
            return;
        }
        depth++;
        if(root.left == null && root.right == null){
            minDepth = Math.min(minDepth, depth);
        }
        dfs(root.left);
        dfs(root.right);

        depth--;
    }
}
