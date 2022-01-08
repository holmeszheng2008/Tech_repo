package array_linked_list.two_pointers.sliding_window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 438. Find All Anagrams in a String
class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        char[] sArray = s.toCharArray();
        char[] pArray = p.toCharArray();
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> needs = new HashMap<>();
        for (char c : pArray) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }
        int i = 0, j = 0;
        int validCounts = 0;

        while (j < s.length()) {
            char c = sArray[j];
            j++;
            if (needs.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(needs.get(c))) {
                    validCounts++;
                }
            }

            while (j - i == p.length()) {
                if (validCounts == needs.size()) {
                    res.add(i);
                }
                char d = sArray[i];
                i++;
                if (needs.containsKey(d)) {
                    if (window.get(d).equals(needs.get(d))) {
                        validCounts--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }

        return res;
    }
}