import java.util.*;

// N-Queens with bitmasks (Hard backtracking)
// Time: ~O(N!) in worst-case, but bitmasks make it fast up to N=14+.
public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[] row = new char[n];
        Arrays.fill(row, '.');
        backtrack(0, n, 0, 0, 0, new ArrayList<>(), res, row);
        return res;
    }

    // cols, diag1, diag2 use bitmasks. diag1 = (r - c + n - 1), diag2 = (r + c)
    private void backtrack(int r, int n, int cols, int diag1, int diag2,
                           List<Integer> queens, List<List<String>> res, char[] template) {
        if (r == n) {
            List<String> board = new ArrayList<>(n);
            for (int qCol : queens) {
                Arrays.fill(template, '.');
                template[qCol] = 'Q';
                board.add(new String(template));
            }
            res.add(board);
            return;
        }
        int available = ((1 << n) - 1) & ~(cols | diag1 | diag2);
        while (available != 0) {
            int pick = available & -available; // lowest set bit
            available -= pick;
            int c = Integer.numberOfTrailingZeros(pick);
            queens.add(c);
            backtrack(r + 1, n,
                      cols | pick,
                      (diag1 | pick) << 1,
                      (diag2 | pick) >> 1,
                      queens, res, template);
            queens.remove(queens.size() - 1);
        }
    }

    // Demo
    public static void main(String[] args) {
        NQueens solver = new NQueens();
        List<List<String>> ans = solver.solveNQueens(8);
        System.out.println("Solutions for n=8: " + ans.size());
        // Print first solution (optional)
        if (!ans.isEmpty()) {
            for (String row : ans.get(0)) System.out.println(row);
        }
    }
}
