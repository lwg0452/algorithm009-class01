import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

  Set<Integer> col = new HashSet<>();
  Set<Integer> pie = new HashSet<>();
  Set<Integer> na = new HashSet<>();

  public List<List<String>> solveNQueens(int n) {
    List<List<String>> res = new ArrayList<>();
    int[][] board = new int[n][n];
    dfs(res, board, 0, n);
    return res;
  }

  private void dfs(List<List<String>> res, int[][] board, int i, int n) {
    if (i == n) {
      res.add(format(board));
      return;
    }
    for (int j = 0; j < n; j++) {
      if (!col.contains(j) && !pie.contains(i + j) && !na.contains(i - j)) {
        board[i][j] = 1;
        col.add(j);
        pie.add(i + j);
        na.add(i - j);
        dfs(res, board, i + 1, n);
        board[i][j] = 0;
        col.remove(j);
        pie.remove(i + j);
        na.remove(i - j);
      }
    }
  }

  private List<String> format(int[][] board) {
    List<String> res = new ArrayList<>();
    for (int i = 0; i < board.length; i++) {
      StringBuilder builder = new StringBuilder();
      for (int j = 0; j < board.length; j++) {
        if (board[i][j] == 0) {
          builder.append('.');
        } else {
          builder.append('Q');
        }
      }
      res.add(builder.toString());
    }
    return res;
  }
}