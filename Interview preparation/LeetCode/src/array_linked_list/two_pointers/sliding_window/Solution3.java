package array_linked_list.two_pointers.sliding_window;

import java.util.HashSet;
import java.util.Set;

// 3. Longest Substring Without Repeating Characters
public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        Set<Character> window = new HashSet<>();
        int left = 0, right = 0;
        while (right < s.length()) {
            char in = s.charAt(right);
            right++;
            if (!window.contains(in)) {
                window.add(in);
                res = (res > window.size()) ? res : window.size();
            } else {
                while (true) {
                    char out = s.charAt(left);
                    left++;
                    if (out != in) {
                        window.remove(out);
                    } else {
                        break;
                    }
                }
            }
        }

        return res;
    }
}