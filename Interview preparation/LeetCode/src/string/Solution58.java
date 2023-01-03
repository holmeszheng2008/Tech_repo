package string;

// 58. Length of Last Word
public class Solution58 {
    public int lengthOfLastWord(String s) {
        int lastSpaceIndex = s.length(), letterIndex = -1;
        for(int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) == ' ') {
                if(letterIndex != -1){
                    break;
                }
                lastSpaceIndex = i;
            } else {
                letterIndex = i;
            }
        }

        return lastSpaceIndex - letterIndex;
    }
}
