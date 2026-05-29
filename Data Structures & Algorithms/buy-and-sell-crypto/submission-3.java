class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) return 0;

        int left = 0;
        int maxProfit = 0;

        for (int right = 1; right < prices.length; right++) {
            if (prices[right] > prices[left]){
                int currentPotentialProfit = prices[right] - prices[left];
                maxProfit = Math.max(currentPotentialProfit, maxProfit);
            } else {
                left = right;
            }
        }

        return maxProfit;
    }
}
