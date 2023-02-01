package backtracking;

import java.util.ArrayList;
import java.util.List;

// 93. Restore IP Addresses
public class Solution93 {
    private List<String> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    private String s;
    public List<String> restoreIpAddresses(String s) {
        if(s.length() < 4 || s.length() > 12){
            return res;
        }

        this.s = s;
        backtracking(0, 0);

        return res;
    }

    private void backtracking(int dotIndex, int start){
        for(int i = start; i < start+3; i++){
            if(!isValid(start, i)){
                return;
            }
            path.add(i);

            if(dotIndex == 2) {
                if(isValid(i+1, s.length() - 1)){
                    res.add(convertToStr());
                }
            } else {
                backtracking(dotIndex + 1, i + 1);
            }

            path.remove(path.size() - 1);
        }
    }

    private boolean isValid(int start, int end){
        if(start > end || start >= s.length() || end >= s.length()) {
            return false;
        }
        int size = end + 1 - start;
        if(size > 3 || size < 1){
            return false;
        }
        if(start == end && s.charAt(start) == '0'){
            return true;
        }

        if(s.charAt(start) == '0'){
            return false;
        }

        int sum = 0;
        for(int i = start; i <= end; i++){
            sum = sum * 10 + s.charAt(i) - '0';
        }

        if(sum > 255){
            return false;
        }

        return true;
    }

    private String convertToStr(){
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(0, path.get(0)+1)).append('.');
        sb.append(s.substring(path.get(0)+1, path.get(1) + 1)).append('.');
        sb.append(s.substring(path.get(1) + 1, path.get(2) + 1)).append('.');
        sb.append(s.substring(path.get(2) + 1));

        return sb.toString();
    }
}
