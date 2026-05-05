class Solution {

    public void solveSudoku(char[][] board) {
        helper(board, 0, 0);
    }

    public boolean helper(char[][] board, int row, int col) {
        // Base case: agar last row cross ho gayi → solved
        if (row == board.length) {
            return true;
        }

        int nrow = 0;
        int ncol = 0;

        // Next cell calculate karo
        if (col != board.length - 1) {
            nrow = row;
            ncol = col + 1;
        } else {
            nrow = row + 1;
            ncol = 0;
        }

        // Agar already filled hai → skip
        if (board[row][col] != '.') {
            return helper(board, nrow, ncol);
        } else {
            // Try digits 1 to 9
            for (int i = 1; i <= 9; i++) {
                if (isSafe(board, row, col, i)) {
                    board[row][col] = (char) (i + '0');

                    if (helper(board, nrow, ncol)) {
                        return true;
                    } else {
                        // backtrack
                        board[row][col] = '.';
                    }
                }
            }
        }

        return false;
    }

    public boolean isSafe(char[][] board, int row, int col, int num) {
        char ch = (char) (num + '0');

        // Row check
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == ch) {
                return false;
            }
        }

        // Column check
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == ch) {
                return false;
            }
        }

        // 3x3 grid check
        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;

        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (board[i][j] == ch) {
                    return false;
                }
            }
        }

        return true;
    }
}