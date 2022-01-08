package array_linked_list.two_pointers.sliding_window;

import java.util.HashMap;
import java.util.Map;

// 3. Longest Substring Without Repeating Characters
public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        if (s.length() == 0) {
            return res;
        }
        char[] sArray = s.toCharArray();
        Map<Character, Integer> window = new HashMap<>();

        int i = 0, j = 0;
        while (j < s.length()) {
            char c = sArray[j];
            j++;
            window.put(c, window.getOrDefault(c, 0) + 1);
            if (window.get(c) == 1) {
                res = Math.max(res, j - i);
            }
            while (window.get(c) == 2) {
                char d = sArray[i];
                i++;
                window.put(d, window.get(d) - 1);
            }
        }

        return res;
    }
}