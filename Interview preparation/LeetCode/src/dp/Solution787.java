package dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 787. Cheapest Flights Within K Stops
public class Solution787 {
    private Map<Integer, List<int[]>> fromToTos = new HashMap<>();
    private Integer[][] memo;
    private int dst;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        for (int[] i : flights) {
            int from = i[0];
            int to = i[1];
            int price = i[2];
            List<int[]> tos = null;
            if (fromToTos.containsKey(from)) {
                tos = fromToTos.get(from);
            } else {
                tos = new ArrayList<>();
                fromToTos.put(from, tos);
            }
            tos.add(new int[] {to, price});
        }

        this.memo = new Integer[n][k + 1];
        this.dst = dst;

        int res = dp(src, k);
        return (res == Integer.MAX_VALUE) ? -1 : res;
    }

    private int dp(int src, int k) {
        if (src == dst) {
            return 0;
        }
        if (k == -1) {
            return Integer.MAX_VALUE;
        }

        if (memo[src][k] != null) {
            return memo[src][k];
        }

        List<int[]> tos = fromToTos.get(src);
        int res = Integer.MAX_VALUE;
        if (tos != null) {
            for (int[] toArray : tos) {
                int subRes = dp(toArray[0], k - 1);
                if (subRes != Integer.MAX_VALUE) {
                    res = Math.min(res, subRes + toArray[1]);
                }
            }
        }
        

        memo[src][k] = res;
        return res;
    }
}