package greedy;

// 134. Gas Station
// Brute force traverse
class Solution134_bf {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;
        for(int i = 0; i < length; i++) {
            if (checkFromStart(i, length, gas, cost)){
                return i;
            }
        }

        return -1;
    }
    private boolean checkFromStart(int start, int length, int[] gas, int[] cost){
        int total = 0;
        for(int i = start; i < start + length; i ++){
            int index = i % length;
            total += gas[index] - cost[index];
            if (total < 0) {
                return false;
            }
        }

        return true;
    }
}

class Solution134_graph {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int minTotal =Integer.MAX_VALUE;
        int lowestIndex = 0;
        for(int i = 0; i < gas.length; i++){
            total += gas[i] - cost[i];
            if (total < minTotal){
                minTotal = total;
                lowestIndex = i;
            }
        }

        if (total < 0){
            return -1;
        } else {
            return (lowestIndex + 1) % gas.length;
        }
    }
}

public class Solution134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        for(int i = 0; i < gas.length; i++){
            sum += gas[i] - cost[i];
        }
        if (sum < 0){
            return -1;
        }

        sum = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++){
            sum += gas[i] - cost[i];
            if (sum < 0){
                start = i+1;
                sum = 0;
            }
        }

        return start;
    }
}