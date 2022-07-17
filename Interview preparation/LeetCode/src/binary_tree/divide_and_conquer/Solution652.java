package binary_tree.divide_and_conquer;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import util.TreeNode;

// 652. Find Duplicate Subtrees
public class Solution652 {
    private String NULL = "#";
    private String SEP = ",";

    private List<TreeNode> res = new LinkedList<>();
    private Map<String, Integer> map = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        getSerialStr(root);
        return res;
    }

    private String getSerialStr(TreeNode root) {
        if (root == null) {
            return NULL;
        }
        String serialStr = root.val + SEP + getSerialStr(root.left) + SEP + getSerialStr(root.right);
        if (map.getOrDefault(serialStr, 0) == 1) {
            res.add(root);
        }
        map.put(serialStr, map.getOrDefault(serialStr, 0) + 1);

        return serialStr;
    }
}
