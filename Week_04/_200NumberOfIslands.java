class Solution {

  int[] dx = {-1, 1, 0, 0};
  int[] dy = {0, 0, -1, 1};

  //染色法
  public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }
    int m = grid.length;
    int n = grid[0].length;
    int res = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == '1') {
          res++;
          dfs(grid, i, j);
        }
      }
    }
    return res;
  }

  private void dfs(char[][] grid, int x, int y) {
    int m = grid.length;
    int n = grid[0].length;
    if (x < 0 || x >= m || y < 0 || y >= n) {
      return;
    }
    if (grid[x][y] == '0') {
      return;
    }
    grid[x][y] = '0';
    for (int i = 0; i < 4; i++) {
      dfs(grid, x + dx[i], y + dy[i]);
    }
  }
}