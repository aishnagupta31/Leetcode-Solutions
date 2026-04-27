class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);  // mark all as uncomputed
        return solve(0, arr, k, dp);
    }

    private int solve(int i, int[] arr, int k, int[] dp) {
        // Base case
        if (i == arr.length) return 0;

        // Memo check
        if (dp[i] != -1) return dp[i];

        int max = 0;
        int best = 0;
        int len = 0;

        // Try all partition sizes
        for (int j = i; j < arr.length && j < i + k; j++) {
            max = Math.max(max, arr[j]);
            len++;

            int sum = max * len + solve(j + 1, arr, k, dp);
            best = Math.max(best, sum);
        }

        return dp[i] = best;
    }
}