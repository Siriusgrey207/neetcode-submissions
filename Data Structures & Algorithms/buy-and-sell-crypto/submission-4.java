class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) return 0;

        int left = 0;
        int maxProfit = 0;

        for (int right = 0; right < prices.length; right++) {
            if (prices[right] > prices[left]) {
                int potentialProfit = prices[right] - prices[left];
                maxProfit = Math.max(maxProfit, potentialProfit);
            } else {
                left = right;
            }
        }

        return maxProfit;
    }
}
