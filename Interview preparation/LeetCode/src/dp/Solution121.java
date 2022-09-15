package dp;

// 121. Best Time to Buy and Sell Stock
public class Solution121 {
    public int maxProfit(int[] prices) {
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < buyPrice) {
                buyPrice = price;
            } else {
                maxProfit = Math.max(maxProfit, price - buyPrice);
            }
        }

        return maxProfit;
    }
}
