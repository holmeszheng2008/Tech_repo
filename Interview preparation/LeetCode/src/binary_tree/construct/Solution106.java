package binary_tree.construct;

import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

// 106. Construct Binary Tree from Inorder and Postorder Traversal
public class Solution106 {
    private Map<Integer, Integer> inorderIndexMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return build(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    public TreeNode build(int[] inorder, int[] postorder, int inleft, int inright, int postleft, int postright) {
        if (postleft > postright) {
            return null;
        }
        if (postleft == postright) {
            TreeNode node = new TreeNode(postorder[postright]);
            return node;
        }
        int value = postorder[postright];
        int inIndex = inorderIndexMap.get(value);
        int leftSize = inIndex - inleft;
        int rightSize = inright - inIndex;

        TreeNode node = new TreeNode();
        node.val = value;
        node.left = build(inorder, postorder, inleft, inIndex - 1, postleft, postleft + leftSize - 1);
        node.right = build(inorder, postorder, inIndex + 1, inright, postleft + leftSize, postright - 1);

        return node;
    }
}
