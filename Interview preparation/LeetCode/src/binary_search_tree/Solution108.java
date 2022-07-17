package binary_search_tree;

import util.TreeNode;

// 108. Convert Sorted Array to Binary Search Tree
public class Solution108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = low + (high - low) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = build(nums, low, mid - 1);
        node.right = build(nums, mid + 1, high);

        return node;
    }
}
