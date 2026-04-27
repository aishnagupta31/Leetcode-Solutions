class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1]; // dp[n] = 0 by default

        // Fill from right to left
        for (int i = n - 1; i >= 0; i--) {
            int max = 0;
            int best = 0;
            int len = 0;

            // Try all partition sizes
            for (int j = i; j < n && j < i + k; j++) {
                max = Math.max(max, arr[j]);
                len++;

                int sum = max * len + dp[j + 1];
                best = Math.max(best, sum);
            }

            dp[i] = best;
        }

        return dp[0];
    }
}