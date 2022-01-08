package array_linked_list.two_pointers.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class Solution567_try1 {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> needs = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        int validCounts = 0;
        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();
        for (char c : s1Array) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }

        int i = 0, j = 0;
        while (j < s2Array.length) {
            char c = s2Array[j];
            j++;
            if (needs.containsKey(c)) {
                int count = window.getOrDefault(c, 0);
                if (count < needs.get(c)) {
                    window.put(c, count + 1);
                    if (count + 1 == needs.get(c)) {
                        validCounts++;
                        if (validCounts == needs.size()) {
                            return true;
                        }
                    }
                } else {
                    window.put(c, count + 1);
                    while (i < j) {
                        char toRemove = s2Array[i];
                        int currentCount = window.get(toRemove);
                        if (currentCount == needs.get(toRemove)) {
                            validCounts--;
                        }
                        window.put(toRemove, currentCount - 1);
                        i++;
                        if (toRemove == c) {
                            break;
                        }
                    }
                }
            } else {
                i = j;
                for (Character ch : window.keySet()) {
                    window.put(ch, 0);
                }
                validCounts = 0;
            }
        }
        return false;
    }
}
