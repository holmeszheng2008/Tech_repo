package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 131. Palindrome Partitioning
public class Solution131 {
    private List<List<String>> res = new ArrayList<>();
    private LinkedList<String> path = new LinkedList<>();
    private String s;
    public List<List<String>> partition(String s) {
        this.s = s;

        backtracking(0);

        return res;
    }

    private void backtracking(int start){
        for(int end = start; end < s.length(); end++){
            String substring = s.substring(start, end + 1);
            if(!isPalindrome(substring)){
                continue;
            }

            path.add(substring);
            if(end == s.length() - 1){
                res.add(new ArrayList<>(path));
            } else {
                backtracking(end + 1);
            }

            path.removeLast();
        }
    }

    private boolean isPalindrome(String s){
        int left = 0, right = s.length() - 1;
        while(left <= right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}

class Solution131_attempt1 {
    private List<List<String>>[] memo;
    private int n;
    private String s;
    public List<List<String>> partition(String s) {
        this.n = s.length();
        this.s = s;
        this.memo = new ArrayList[n];

        return dp(0);
    }

    private List<List<String>> dp(int index){
        if(memo[index] != null){
            return memo[index];
        }

        List<List<String>> results = new ArrayList<>();
        for(int end = index; end < n; end++){
            String substring = s.substring(index, end + 1);
            if(!isPalindrome(substring)){
                continue;
            }

            if(end == n-1){
                List<String> res1 = new ArrayList<>();
                res1.add(substring);
                results.add(res1);
            } else{
                List<List<String>> nextResults = dp(end + 1);
                for(List<String> nextResult : nextResults){
                    List<String> res = new ArrayList<>();
                    res.add(substring);
                    res.addAll(nextResult);
                    results.add(res);
                }
            }
        }

        memo[index] = results;

        return results;
    }

    private boolean isPalindrome(String s){
        int left = 0, right = s.length() - 1;
        while(left <= right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}