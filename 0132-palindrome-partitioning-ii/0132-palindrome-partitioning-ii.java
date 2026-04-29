class Solution {

    // Same palindrome check
    public boolean isPalindrome(int i, int j, String s) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    public int minCut(String s) {
        int n = s.length();

        // dp[i] = minimum partitions from i → end
        int[] dp = new int[n + 1];

        dp[n] = 0; // base case (same as recursion)

        // fill from right to left
        for (int i = n - 1; i >= 0; i--) {
            int minCost = Integer.MAX_VALUE;

            for (int j = i; j < n; j++) {
                if (isPalindrome(i, j, s)) {
                    int cost = 1 + dp[j + 1];
                    minCost = Math.min(minCost, cost);
                }
            }

            dp[i] = minCost;
        }

        return dp[0] - 1; // same adjustment
    }
}