class Solution {

  public boolean isValidSudoku(char[][] board) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] != '.' && !isValid(board, i, j)) {
          return false;
        }
      }
    }
    return true;
  }

  private boolean isValid(char[][] board, int x, int y) {
    char c = board[x][y];
    for (int i = 0; i < 9; i++) {
      if (board[i][y] == c && i != x) {
        return false;
      }
      if (board[x][i] == c && i != y) {
        return false;
      }
    }
    int block = x / 3 * 3 + y / 3, ii = block / 3 * 3, jj = block % 3 * 3;
    for (int i = ii; i < ii + 3; i++) {
      for (int j = jj; j < jj + 3; j++) {
        if (board[i][j] == c && !(i == x && j == y)) {
          return false;
        }
      }
    }
    return true;
  }
}