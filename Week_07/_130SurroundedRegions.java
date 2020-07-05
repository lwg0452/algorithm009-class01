//并查集
class Solution {

  public void solve(char[][] board) {
    if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
      return;
    }
    int m = board.length, n = board[0].length;
    UnionFind uf = new UnionFind(m * n + 1);
    //构造并查集，将和边界相连的O与并查集中的m * n归为一类
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (board[i][j] == 'O') {
          //边界的O
          if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
            uf.union(m * n, i * n + j);
          } else {
            //非边界,将其和附近的O归为一类
            if (board[i - 1][j] == 'O') {
              uf.union(i * n + j, (i - 1) * n + j);
            }
            if (board[i + 1][j] == 'O') {
              uf.union(i * n + j, (i + 1) * n + j);
            }
            if (board[i][j - 1] == 'O') {
              uf.union(i * n + j, i * n + j - 1);
            }
            if (board[i][j + 1] == 'O') {
              uf.union(i * n + j, i * n + j + 1);
            }
          }
        }
      }
    }
    //修改，将不与边界相连的O改为X
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (board[i][j] == 'O' && !uf.isConnected(m * n, i * n + j)) {
          board[i][j] = 'X';
        }
      }
    }
  }

  class UnionFind {

    int[] parents;

    public UnionFind(int n) {
      parents = new int[n];
      for (int i = 0; i < n; i++) {
        parents[i] = i;
      }
    }

    public int find(int p) {
      while (parents[p] != p) {
        parents[p] = parents[parents[p]];
        p = parents[p];
      }
      return p;
    }

    public void union(int p, int q) {
      p = find(p);
      q = find(q);
      if (p == q) {
        return;
      }
      parents[p] = q;
    }

    public boolean isConnected(int p, int q) {
      return find(p) == find(q);
    }
  }
}

////dfs
////枚举棋盘的上下左右边界将与边界相连的O用dfs改成#
////然后遍历棋盘，将所有O改为X，将所有#改回O
//class Solution {
//
//  int[] dx = {-1, 1, 0, 0};
//  int[] dy = {0, 0, -1, 1};
//
//  public void solve(char[][] board) {
//    if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
//      return;
//    }
//    int m = board.length, n = board[0].length;
//    //枚举左右边界
//    for (int i = 0; i < m; i++) {
//      if (board[i][0] == 'O') {
//        dfs(board, i, 0);
//      }
//      if (board[i][n - 1] == 'O') {
//        dfs(board, i, n - 1);
//      }
//    }
//    //枚举上下边界
//    for (int j = 0; j < n; j++) {
//      if (board[0][j] == 'O') {
//        dfs(board, 0, j);
//      }
//      if (board[m - 1][j] == 'O') {
//        dfs(board, m - 1, j);
//      }
//    }
//    //修改
//    for (int i = 0; i < m; i++) {
//      for (int j = 0; j < n; j++) {
//        if (board[i][j] == 'O') {
//          board[i][j] = 'X';
//        } else if (board[i][j] == '#') {
//          board[i][j] = 'O';
//        }
//      }
//    }
//  }
//
//  private void dfs(char[][] board, int x, int y) {
//    int m = board.length, n = board[0].length;
//    if (x < 0 || x >= m || y < 0 || y >= n || board[x][y] != 'O') {
//      return;
//    }
//    board[x][y] = '#';
//    for (int i = 0; i < 4; i++) {
//      dfs(board, x + dx[i], y + dy[i]);
//    }
//  }
//}