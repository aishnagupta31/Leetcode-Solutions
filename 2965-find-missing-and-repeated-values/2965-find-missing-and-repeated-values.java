class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int size = n * n;
        int[] freq = new int[size + 1];
        int[] res = new int[2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                freq[grid[i][j]]++;
            }
        }

        for (int i = 1; i <= size; i++) {
            if (freq[i] == 2) {
                res[0] = i; // repeated
            } else if (freq[i] == 0) {
                res[1] = i; // missing
            }
        }

        return res;
    }
}