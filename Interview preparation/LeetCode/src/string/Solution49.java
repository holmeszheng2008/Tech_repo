package string;

import java.util.*;

// 49. Group Anagrams
public class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] cArray = str.toCharArray();
            Arrays.sort(cArray);
            String sortedStr = String.valueOf(cArray);
            List<String> col = map.get(sortedStr);
            if(col == null){
                col = new ArrayList<>();
                map.put(sortedStr, col);
            }

            col.add(str);
        }

        List<List<String>> res = new ArrayList<>(map.values());
        return res;
    }
}


class Solution49_attempt1 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            String code = encode(str);
            List<String> col = map.get(code);
            if(col == null){
                col = new ArrayList<>();
                map.put(code, col);
            }

            col.add(str);
        }

        List<List<String>> res = new ArrayList<>(map.values());
        return res;
    }

    private String encode(String str){
        char[] sArray = new char[26];
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            sArray[c-'a']++;
        }

        return String.valueOf(sArray);
    }
}