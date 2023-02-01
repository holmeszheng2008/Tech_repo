package misc.math;

// 67. Add Binary
public class Solution67 {
    private int[] sum;
    private int carry;

    public String addBinary(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();

        if(aLen < bLen){
            return addBinary(b, a);
        }

        this.sum = new int[aLen];
        addToIndex(aLen, bLen, a, b, 0, 0);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < aLen; i++){
            sb.append(sum[i]);
        }

        if(carry == 0){
            return sb.toString();
        } else {
            return "1" + sb.toString();
        }
    }

    private void addToIndex(int aLen, int bLen, String a, String b, int digitIndex, int add){
        if(aLen - 1 - digitIndex < 0){
            this.carry = add;
            return;
        }

        int tempSum = 0;
        if(bLen - 1 - digitIndex < 0){
            int aIndex = aLen - 1 - digitIndex;
            tempSum = a.charAt(aIndex) - '0' + add;
        } else {
            int aIndex = aLen - 1 - digitIndex;
            int bIndex = bLen - 1 - digitIndex;
            tempSum = a.charAt(aIndex) - '0' + b.charAt(bIndex) - '0' + add;
        }

        sum[aLen - 1 - digitIndex] = tempSum % 2;
        addToIndex(aLen, bLen, a, b, digitIndex + 1, tempSum / 2);
    }
}
