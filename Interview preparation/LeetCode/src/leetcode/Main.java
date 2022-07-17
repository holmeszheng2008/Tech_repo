package leetcode;

import binary_tree.divide_and_conquer.Solution508;
import util.TreeNode;

public class Main {

    public static void main(String[] args) {

        Solution508 instance = new Solution508();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-3);
        instance.findFrequentTreeSum(root);
    }
}
