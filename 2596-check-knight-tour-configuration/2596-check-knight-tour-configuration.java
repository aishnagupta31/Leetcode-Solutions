class Solution {
    public boolean checkValidGrid(int[][] grid) {
        // The knight must start at the top-left cell (0, 0)
        if (grid[0][0] != 0) return false;
        
        int n = grid.length;
        return isValid(grid, 0, 0, n, 0);
    }

    public boolean isValid(int[][] grid, int r, int c, int n, int expVal) {
        // Base Case: Out of bounds or current cell doesn't match expected value
        if (r < 0 || c < 0 || r >= n || c >= n || grid[r][c] != expVal) {
            return false;
        }

        // Base Case: If we've reached the last cell (n*n - 1)
        if (expVal == n * n - 1) {
            return true;
        }

        // Check all 8 possible L-shaped knight moves
        boolean ans1 = isValid(grid, r - 2, c + 1, n, expVal + 1);
        boolean ans2 = isValid(grid, r - 1, c + 2, n, expVal + 1);
        boolean ans3 = isValid(grid, r + 1, c + 2, n, expVal + 1);
        boolean ans4 = isValid(grid, r + 2, c + 1, n, expVal + 1);
        boolean ans5 = isValid(grid, r + 2, c - 1, n, expVal + 1);
        boolean ans6 = isValid(grid, r + 1, c - 2, n, expVal + 1);
        boolean ans7 = isValid(grid, r - 1, c - 2, n, expVal + 1);
        boolean ans8 = isValid(grid, r - 2, c - 1, n, expVal + 1);
        
        return ans1 || ans2 || ans3 || ans4 || ans5 || ans6 || ans7 || ans8;
    }
}