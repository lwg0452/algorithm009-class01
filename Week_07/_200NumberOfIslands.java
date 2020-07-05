//并查集
class Solution {

  public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
      return 0;
    }
    int m = grid.length, n = grid[0].length;
    UnionFind uf = new UnionFind(m * n);
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == '1') {
          if (i > 0 && grid[i - 1][j] == '1') {
            uf.union(i * n + j, (i - 1) * n + j);
          }
          if (j > 0 && grid[i][j - 1] == '1') {
            uf.union(i * n + j, i * n + j - 1);
          }
          if (j < n - 1 && grid[i][j + 1] == '1') {
            uf.union(i * n + j, i * n + j + 1);
          }
          if (i < m - 1 && grid[i + 1][j] == '1') {
            uf.union(i * n + j, (i + 1) * n + j);
          }
        } else {
          uf.count--;
        }
      }
    }
    return uf.count;
  }

  class UnionFind {

    int count;
    int[] root;

    public UnionFind(int n) {
      count = n;
      root = new int[n];
      for (int i = 0; i < n; i++) {
        root[i] = i;
      }
    }

    public int find(int p) {
      while (root[p] != p) {
        int temp = p;
        p = root[p];
        root[temp] = p;
      }
      return p;
    }

    public void union(int p, int q) {
      p = find(p);
      q = find(q);
      if (p == q) {
        return;
      }
      root[p] = q;
      count--;
    }
  }
}


////染色法
//class Solution {
//
//  int[] dx = {-1, 1, 0, 0};
//  int[] dy = {0, 0, -1, 1};
//
//  public int numIslands(char[][] grid) {
//    if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
//      return 0;
//    }
//    int res = 0, m = grid.length, n = grid[0].length;
//    for (int i = 0; i < m; i++) {
//      for (int j = 0; j < n; j++) {
//        if (grid[i][j] == '1') {
//          res++;
//          dfs(grid, i, j);
//        }
//      }
//    }
//    return res;
//  }
//
//  //将x，y所在的岛屿全部染成'0'
//  private void dfs(char[][] grid, int x, int y) {
//    int m = grid.length, n = grid[0].length;
//    if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == '0') {
//      return;
//    }
//    grid[x][y] = '0';
//    for (int i = 0; i < 4; i++) {
//      dfs(grid, x + dx[i], y + dy[i]);
//    }
//  }
//}