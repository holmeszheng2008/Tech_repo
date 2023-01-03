package misc;

// 38. Count and Say
public class Solution38 {
    public String countAndSay(int n) {
        if(n == 1){
            return "1";
        }
        String str = countAndSay(n-1);
        StringBuilder sb = new StringBuilder();
        int size = 0;
        char lastC = '*';
        for(char c : str.toCharArray()){
            if(c == lastC){
                size++;
            } else {
                 if(lastC != '*'){
                    sb.append(size).append(lastC);
                 }
                size = 1;
                lastC = c;
            }
        }


        sb.append(size).append(lastC);
        return sb.toString();
    }
}
