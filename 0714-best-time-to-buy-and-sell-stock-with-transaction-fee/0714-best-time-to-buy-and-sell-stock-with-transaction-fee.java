class Solution {
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length == 0) return 0;

        int n = prices.length;
        int cash = 0;          // No stock in hand
        int hold = -prices[0]; // Bought stock on day 0

        for (int i = 1; i < n; i++) {
            // Update cash: either do nothing or sell stock today
            cash = Math.max(cash, hold + prices[i] - fee);

            // Update hold: either do nothing or buy stock today
            hold = Math.max(hold, cash - prices[i]);
        }

        return cash;
    }
}
