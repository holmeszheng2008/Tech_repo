package binary_tree.divide_and_conquer;

import java.util.LinkedList;

// 331. Verify Preorder Serialization of a Binary Tree
public class Solution331 {
    public boolean isValidSerialization(String preorder) {
        String[] sArray = preorder.split(",");
        LinkedList<String> list = new LinkedList<>();
        for (String s : sArray) {
            list.add(s);
        }
        
        return check(list) && list.isEmpty();
    }

    public boolean check(LinkedList<String> list) {
        if (list.isEmpty()) {
            return false;
        }
        String s = list.removeFirst();
        if (s.equals("#")) {
            return true;
        }

        return check(list) && check(list);
    }

}
