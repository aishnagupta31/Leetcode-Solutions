class Solution {
    int[][] dp;

    public int solve(List<int[]> players, int i, int prev) {
        if (i == players.size()) return 0;

        if (dp[i][prev + 1] != -1) {
            return dp[i][prev + 1];
        }

        int skip = solve(players, i + 1, prev);

        int take = 0;

        // If no previous selected, always can take
        // If sorted by age descending, then scores must be non-increasing
        if (prev == -1 || players.get(i)[1] <= players.get(prev)[1]) {
            take = players.get(i)[1] + solve(players, i + 1, i);
        }

        return dp[i][prev + 1] = Math.max(take, skip);
    }

    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        List<int[]> players = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            players.add(new int[]{ages[i], scores[i]});
        }

        // Correct sorting:
        // 1. Age descending
        // 2. If same age, score descending
        players.sort((a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            return b[0] - a[0];
        });

        dp = new int[n][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(players, 0, -1);
    }
}