class Solution {

  public void solveSudoku(char[][] board) {
    dfs(board, 0);
  }

  private boolean dfs(char[][] board, int n) {
    if (n == 81) {
      return true;
    }
    int x = n / 9, y = n % 9;
    if (board[x][y] != '.') {
      return dfs(board, n + 1);
    }
    boolean[] used = new boolean[10];
    markUsed(board, x, y, used);
    for (char c = '1'; c <= '9'; c++) {
      if (used[c - '0']) {
        continue;
      }
      board[x][y] = c;
      if (dfs(board, n + 1)) {
        return true;
      }
      board[x][y] = '.';
    }
    if (board[x][y] == '.') {
      return false;
    }
    return true;
  }


  private void markUsed(char[][] board, int x, int y, boolean[] used) {
    for (int i = 0; i < 9; i++) {
      if (board[i][y] != '.') {
        used[board[i][y] - '0'] = true;
      }
      if (board[x][i] != '.') {
        used[board[x][i] - '0'] = true;
      }
    }
    int block = x / 3 * 3 + y / 3, ii = block / 3 * 3, jj = block % 3 * 3;
    for (int i = ii; i < ii + 3; i++) {
      for (int j = jj; j < jj + 3; j++) {
        if (board[i][j] != '.') {
          used[board[i][j] - '0'] = true;
        }
      }
    }
  }
}