public class SudokuSolver {
    public static boolean solve(int[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;
                            if (solve(board)) return true;
                            board[row][col] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    static boolean isValid(int[][] b, int r, int c, int n) {
        for (int i = 0; i < 9; i++)
            if (b[r][i] == n || b[i][c] == n ||
                    b[3*(r/3) + i/3][3*(c/3) + i%3] == n) return false;
        return true;
    }

    public static void print(int[][] b) {
        for (int[] row : b) {
            for (int num : row) System.out.print(num + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] board = {
                {5,3,0,0,7,0,0,0,0},
                {6,0,0,1,9,5,0,0,0},
                {0,9,8,0,0,0,0,6,0},
                {8,0,0,0,6,0,0,0,3},
                {4,0,0,8,0,3,0,0,1},
                {7,0,0,0,2,0,0,0,6},
                {0,6,0,0,0,0,2,8,0},
                {0,0,0,4,1,9,0,0,5},
                {0,0,0,0,8,0,0,7,9}
        };
        solve(board);
        print(board);
    }
}
