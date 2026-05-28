class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) return 0;

        int maxProfit = 0;
        int left = 0;

        for (int right = 1; right < prices.length; right++) {
            if (prices[left] < prices[right]) {
                int potentialMaxProfit = prices[right] - prices[left];
                maxProfit = Math.max(maxProfit, potentialMaxProfit);
            } else {
                left = right;
            }
        }

        return maxProfit;
    }
}
