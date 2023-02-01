package misc.math;

// 50. Pow(x, n)
public class Solution50 {
    public double myPow(double x, int n) {
        if(n == 0){
            return 1;
        }
        double operand = (n > 0) ? x : 1/x;

        if(n == Integer.MIN_VALUE){
            n = Integer.MAX_VALUE;
            return operand * doPow(operand, n);
        } else {
            n = Math.abs(n);
            return doPow(operand, n);
        }
    }

    // x, n > 0
    private double doPow(double x, int n){
        if(n == 0){
            return 1;
        }
        if (n == 1){
            return x;
        }

        double res = 0;
        if (n % 2 == 0){
            double tempRes = doPow(x, n/2);
            res = tempRes * tempRes;
        } else {
            double tempRes = doPow(x, n-1);
            res = x * tempRes;
        }

        return res;
    }
}

class Solution50_attempt1 {
    public double myPow(double x, int n) {
        if(x == 0 && n < 0){
            return -1;
        }

        if(n < 0){
            x = 1/x;
            if(n == Integer.MIN_VALUE){
                n = Integer.MAX_VALUE;
                return x * doPow(x, n);
            }
            n = -n;
            return doPow(x, n);
        }

        return doPow(x, n);
    }

    // n >= 0
    private double doPow(double x, int n){
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return x;
        }
        if(n == 2){
            return x * x;
        }
        if(n % 2 == 0){
            return doPow(doPow(x, n/2), 2);
        } else {
            return doPow(x, n-1) * x;
        }
    }
}
