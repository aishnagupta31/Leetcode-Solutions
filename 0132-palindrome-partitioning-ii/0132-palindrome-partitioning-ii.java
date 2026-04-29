class Solution {
    
    // Check if substring s[i...j] is palindrome
    public boolean isPalindrome(int i, int j, String s) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    // Recursive function with memoization
    public int f(int i, int n, String s, int[] dp) {
        // Base case
        if (i == n) return 0;

        // Memoization check
        if (dp[i] != -1) return dp[i];

        int minCost = Integer.MAX_VALUE;

        for (int j = i; j < n; j++) {
            if (isPalindrome(i, j, s)) {
                int cost = 1 + f(j + 1, n, s, dp);
                minCost = Math.min(minCost, cost);
            }
        }

        return dp[i] = minCost;
    }

    public int minCut(String s) {
        int n = s.length();

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        // subtract 1 because last partition doesn't need a cut
        return f(0, n, s, dp) - 1;
    }
}