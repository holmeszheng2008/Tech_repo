package array_linked_list.two_pointers.sliding_window;

import java.util.HashMap;
import java.util.Map;

// 76. Minimum Window Substring
public class Solution76 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        char[] tArray = t.toCharArray();
        for (char c : tArray) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0, valid = 0, length = Integer.MAX_VALUE;
        int start = 0, end = 0;
        while (right < s.length()) {
            Character in = s.charAt(right);
            right++;
            if (need.get(in) != null) {
                window.put(in, window.getOrDefault(in, 0) + 1);
                if (window.get(in).equals(need.get(in))) {
                    valid++;
                }
            }
            while (valid == need.size()) {
                int currentLength = right - left;
                if (currentLength < length) {
                    length = currentLength;
                    start = left;
                    end = right;
                }
                Character out = s.charAt(left);
                left++;
                if (need.get(out) != null) {
                    window.put(out, window.get(out) - 1);
                    if (window.get(out).equals(need.get(out) - 1)) {
                        valid--;
                    }
                }
            }
        }

        return s.substring(start, end);
    }
}


