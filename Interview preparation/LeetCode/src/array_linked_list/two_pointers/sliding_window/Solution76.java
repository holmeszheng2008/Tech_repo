package array_linked_list.two_pointers.sliding_window;

import java.util.HashMap;
import java.util.Map;

// 76. Minimum Window Substring
public class Solution76 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> needs = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        for (char c : tArray) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }
        int i = 0, j = 0;
        int satisfied = 0;
        int start = 0, len = Integer.MAX_VALUE;
        while (j < sArray.length) {
            char c = sArray[j];
            j++;
            if (needs.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(needs.get(c))) {
                    satisfied++;
                }
            }
            while (needs.size() == satisfied) {
                if (len > j - i) {
                    len = j - i;
                    start = i;
                }
                char d = sArray[i];
                i++;
                if (needs.containsKey(d)) {
                    if (window.get(d).equals(needs.get(d))) {
                        satisfied--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }

        if (len == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(start, start + len);
    }
}


