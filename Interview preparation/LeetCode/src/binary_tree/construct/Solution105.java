package binary_tree.construct;

import java.util.HashMap;
import java.util.Map;
import util.TreeNode;

// 105. Construct Binary Tree from Preorder and Inorder Traversal
public class Solution105 {
    private Map<Integer, Integer> inorderIndexMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int[] inorder, int preleft, int preright, int inleft, int inright) {
        if (preleft > preright) {
            return null;
        }
        if (preleft == preright) {
            return new TreeNode(preorder[preleft]);
        }

        int value = preorder[preleft];
        int inIndex = inorderIndexMap.get(value);
        int leftSize = inIndex - inleft;
        int rightSize = inright - inIndex;

        TreeNode node = new TreeNode(value);
        node.left = build(preorder, inorder, preleft + 1, preleft + leftSize, inleft, inIndex - 1);
        node.right = build(preorder, inorder, preleft + leftSize + 1, preright, inIndex + 1, inright);

        return node;
    }
}
