class Solution {
    public int maxProfit(int[] prices) {
        // If we have only 1 opportunity to buy and no opportunities to sell we can't make a profit.
        if (prices.length == 1) return 0;

        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int currentPrice = prices[i];
            if (prices[i] > prices[i - 1]) profit += (prices[i] - prices[i - 1]);
        }
        return profit;
    }
}