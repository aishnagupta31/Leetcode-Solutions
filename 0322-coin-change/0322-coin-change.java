class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        
        int INF = amount + 1; // large value
        
        // Initialize
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0; // 0 coins needed for amount 0
        }
        
        for (int j = 1; j <= amount; j++) {
            dp[0][j] = INF; // impossible with 0 coins
        }
        
        // Fill DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i - 1] <= j) {
                    dp[i][j] = Math.min(1 + dp[i][j - coins[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        
        return dp[n][amount] == INF ? -1 : dp[n][amount];
    }
}