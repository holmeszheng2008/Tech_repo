package binary_search_tree;

import java.util.ArrayList;
import util.ListNode;
import util.TreeNode;

public class Solution109 {
    public TreeNode sortedListToBST(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        for (ListNode i = head; i != null; i = i.next) {
            list.add(i.val);
        }

        return build(list, 0, list.size() - 1);
    }

    private TreeNode build(ArrayList<Integer> list, int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = low + (high - low) / 2;
        TreeNode node = new TreeNode(list.get(mid));
        node.left = build(list, low, mid - 1);
        node.right = build(list, mid + 1, high);

        return node;
    }
}
