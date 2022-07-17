package binary_search_tree;

import java.util.ArrayList;
import java.util.List;
import util.TreeNode;

// 95. Unique Binary Search Trees II
public class Solution95 {
    private Object[][] memo;
    public List<TreeNode> generateTrees(int n) {
        memo = new Object[n + 1][n + 1];
        return construct(1, n);
    }

    private List<TreeNode> construct(int low, int high) {
        if (low > high) {
            return null;
        }
        if (memo[low][high] != null) {
            return (List<TreeNode>) memo[low][high];
        }
        List<TreeNode> resRoots = new ArrayList<>();
        for (int i = low; i <= high; i++) {
            List<TreeNode> leftRoots = construct(low, i - 1);
            List<TreeNode> rightRoots = construct(i + 1, high);
            if (leftRoots == null) {
                if (rightRoots == null) {
                    resRoots.add(new TreeNode(i));
                } else {
                    for (TreeNode rightRoot : rightRoots) {
                        TreeNode root = new TreeNode(i);
                        root.right = rightRoot;
                        resRoots.add(root);
                    }
                }
            } else {
                if (rightRoots == null) {
                    for (TreeNode leftRoot : leftRoots) {
                        TreeNode root = new TreeNode(i);
                        root.left = leftRoot;
                        resRoots.add(root);
                    }
                } else {
                    for (TreeNode leftRoot : leftRoots) {
                        for (TreeNode rightRoot : rightRoots) {
                            TreeNode root = new TreeNode(i);
                            root.left = leftRoot;
                            root.right = rightRoot;
                            resRoots.add(root);
                        }
                    }
                }
            }
        }

        memo[low][high] = resRoots;

        return resRoots;
    }
}
