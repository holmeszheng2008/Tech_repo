package binary_tree.divide_and_conquer;

import util.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution894 {
    private Map<Integer, List<TreeNode>> memo = new HashMap<>();
    public List<TreeNode> allPossibleFBT(int n) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        List<TreeNode> res = new ArrayList<>();
        if (n < 0 || n % 2 == 0) {
            return res;
        }

        if (n == 1) {
            res.add(new TreeNode(0));
            memo.put(1, res);
            return res;
        }

        for (int i = 1; i < n;) {
            List<TreeNode> leftRes = allPossibleFBT(i);
            List<TreeNode> rightRes = allPossibleFBT(n - i - 1);
            for (TreeNode left : leftRes) {
                for (TreeNode right : rightRes) {
                    TreeNode node = new TreeNode(0);
                    node.left = left;
                    node.right = right;
                    res.add(node);
                }
            }
            i += 2;
        }
        memo.put(n, res);
        return res;
    }
}
