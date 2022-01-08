package array_linked_list.two_pointers.sliding_window;

import java.util.HashMap;
import java.util.Map;

// 567. Permutation in String
public class Solution567 {
    public boolean checkInclusion(String s1, String s2) {
        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();
        Map<Character, Integer> needs = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : s1Array) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }
        int validCounts = 0;
        int i = 0, j = 0;

        while (j < s2.length()) {
            char c = s2Array[j];
            j++;
            if (needs.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(needs.get(c))) {
                    validCounts++;
                }
            }

            while (j - i == s1.length()) {
                if (validCounts == needs.size()) {
                    return true;
                }
                char d = s2Array[i];
                i++;
                if (needs.containsKey(d)) {
                    if (window.get(d).equals(needs.get(d))) {
                        validCounts--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return false;
    }
}
