package array_linked_list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 30. Substring with Concatenation of All Words
public class Solution30 {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> wordCount = new HashMap<>();
        for(String word : words){
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        Map<String, Integer> tempWordCount = new HashMap<>();
        int numOfWords = words.length;
        int lengthOfWord = words[0].length();
        int subStrLength = numOfWords * lengthOfWord;
        char[] sArray = s.toCharArray();
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i <= sArray.length - subStrLength; i++){
            int j = i;
            for(; j < i + subStrLength; j += lengthOfWord){
                String str = String.valueOf(sArray, j, lengthOfWord);

                int count = tempWordCount.getOrDefault(str, 0) + 1;
                if(wordCount.getOrDefault(str, 0) < count){
                    break;
                }
                tempWordCount.put(str, count);
            }
            if(j == i + subStrLength){
                res.add(i);
            }

            tempWordCount.clear();
        }

        return res;
    }
}
