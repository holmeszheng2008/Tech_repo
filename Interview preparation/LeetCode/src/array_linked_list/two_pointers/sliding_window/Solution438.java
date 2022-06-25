package array_linked_list.two_pointers.sliding_window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 438. Find All Anagrams in a String
class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        char[] pArray = p.toCharArray();
        Map<Character, Integer> need = new HashMap<>();
        for (char c : pArray) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0, valid = 0;

        while (right < s.length()) {
            char in = s.charAt(right);
            right++;
            if (need.containsKey(in)) {
                window.put(in, window.getOrDefault(in, 0) + 1);
                if (window.get(in).equals(need.get(in))) {
                    valid++;
                } else if (window.get(in).equals(need.get(in) + 1)) {
                    valid--;
                    while (true) {
                        char out = s.charAt(left);
                        left++;
                        window.put(out, window.get(out) - 1);
                        if (window.get(out).equals(need.get(out) - 1)) {
                            valid--;
                        }
                        if (out == in) {
                            valid++;
                            break;
                        }
                    }
                }
            } else {
                window.clear();
                left = right;
                valid = 0;
            }

            if (valid == need.size()) {
                res.add(left);
                valid--;
                char out = s.charAt(left);
                left++;
                window.put(out, window.get(out) - 1);
            }
        }

        return res;
    }
}