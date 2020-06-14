class Solution {

  int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
  int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
  int m;
  int n;

  public char[][] updateBoard(char[][] board, int[] click) {
    m = board.length;
    n = board[0].length;
    dfs(board, click[0], click[1]);
    return board;
  }

  private void dfs(char[][] board, int x, int y) {
    if (x < 0 || x >= m || y < 0 || y >= n) {
      return;
    }
    if (board[x][y] == 'M') {
      board[x][y] = 'X';
      return;
    }
    int count = 0;
    for (int i = 0; i < 8; i++) {
      int tempx = x + dx[i], tempy = y + dy[i];
      if (tempx >= 0 && tempx < m && tempy >= 0 && tempy < n) {
        if (board[tempx][tempy] == 'M') {
          count++;
        }
      }
    }
    if (count != 0) {
      board[x][y] = (char) (count + '0');
      return;
    } else {
      board[x][y] = 'B';
      for (int i = 0; i < 8; i++) {
        int tempx = x + dx[i], tempy = y + dy[i];
        //注意：只有board[tempx][tempy] == 'E'时需要扩展，不加此条件会栈溢出（重复修改已经是数字的格子）
        if (tempx >= 0 && tempx < m && tempy >= 0 && tempy < n && board[tempx][tempy] == 'E') {
          dfs(board, tempx, tempy);
        }
      }
    }
  }
}