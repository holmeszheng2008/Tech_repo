package binary_tree.bfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;
import util.TreeNode;

// 863. All Nodes Distance K in Binary Tree
public class Solution863 {
    private Map<Integer, TreeNode> parentMap = new HashMap<>();
    private Set<Integer> visited = new HashSet<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        traverse(root, null);
        int dist = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);
        visited.add(target.val);
        while (!queue.isEmpty()) {
            if (dist == k) {
                break;
            }
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null && !visited.contains(node.left.val)) {
                    queue.add(node.left);
                    visited.add(node.left.val);
                }
                if (node.right != null && !visited.contains(node.right.val)) {
                    queue.add(node.right);
                    visited.add(node.right.val);
                }
                TreeNode parent = parentMap.get(node.val);
                if (parent != null && !visited.contains(parent.val)) {
                    queue.add(parent);
                    visited.add(parent.val);
                }
            }

            dist++;
        }
        return queue.stream().map(node -> node.val).collect(Collectors.toList());
    }
    
    private void traverse(TreeNode root, TreeNode parentNode) {
        if (root == null) {
            return;
        }
        parentMap.put(root.val, parentNode);
        traverse(root.left, root);
        traverse(root.right, root);
    }
}
