package binary_tree.bfs;

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 103. Binary Tree Zigzag Level Order Traversal
public class Solution103 {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        boolean leftOrder = true;
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> levelList = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (leftOrder) {
                    levelList.addLast(node.val);
                } else {
                    levelList.addFirst(node.val);
                }
            }
            res.add(levelList);
            leftOrder = !leftOrder;
        }

        return res;
    }
}
