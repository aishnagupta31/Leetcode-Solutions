import java.util.*;

class Solution {

    // Function to check if it's safe to place a queen
    private boolean isSafe(char[][] board, int row, int col, int n) {
        // Check the current row
        for (int j = 0; j < n; j++) {
            if (board[row][j] == 'Q') return false;
        }

        // Check the current column
        for (int i = 0; i < n; i++) {
            if (board[i][col] == 'Q') return false;
        }

        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true; // Safe position
    }

    // Backtracking function
    private void solve(int row, char[][] board, int n, List<List<String>> ans) {
        // If all queens are placed, save the current board
        if (row == n) {
            List<String> solution = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                solution.add(new String(board[i])); // convert char[] to String
            }
            ans.add(solution); // Add one valid solution
            return;
        }

        // Try placing the queen in each column of the current row
        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 'Q';           // Place queen
                solve(row + 1, board, n, ans);   // Recurse for next row
                board[row][col] = '.';           // Backtrack
            }
        }
    }

    // Main function to solve N-Queens
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];

        // Initialize board with '.'
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        solve(0, board, n, ans);
        return ans;
    }
}
