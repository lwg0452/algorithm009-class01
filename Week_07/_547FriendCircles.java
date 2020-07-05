//通过visited数组加速dfs
class Solution {

  public int findCircleNum(int[][] M) {
    if (M == null || M.length == 0 || M[0] == null || M[0].length == 0) {
      return 0;
    }
    int n = M.length, res = 0;
    boolean[] visited = new boolean[n];
    for (int i = 0; i < n; i++) {
      //遇到visited[i] == false,说明这个朋友圈没有访问过，res+1，然后访问该朋友圈
      if (!visited[i]) {
        res++;
        dfs(M, visited, i);
      }
    }
    return res;
  }

  //将i所在的朋友圈内的人标记为访问过
  private void dfs(int[][] M, boolean[] visited, int i) {
    visited[i] = true;
    for (int j = 0; j < M.length; j++) {
      if (M[i][j] == 1 && !visited[j]) {
        dfs(M, visited, j);
      }
    }
  }
}

////并查集
//class Solution {
//
//  public int findCircleNum(int[][] M) {
//    if (M == null || M.length == 0 || M[0] == null || M[0].length == 0) {
//      return 0;
//    }
//    int n = M.length;
//    UnionFind uf = new UnionFind(n);
//    for (int i = 0; i < n; i++) {
//      for (int j = 0; j < n; j++) {
//        if (M[i][j] == 1) {
//          uf.union(i, j);
//        }
//      }
//    }
//    return uf.count;
//  }
//
//  class UnionFind {
//
//    int count;
//    int[] root;
//
//    public UnionFind(int n) {
//      count = n;
//      root = new int[n];
//      for (int i = 0; i < n; i++) {
//        root[i] = i;
//      }
//    }
//
//    public int find(int p) {
//      while (root[p] != p) {
//        int temp = p;
//        p = root[p];
//        root[temp] = p;
//      }
//      return p;
//    }
//
//    public void union(int p, int q) {
//      p = find(p);
//      q = find(q);
//      if (p == q) {
//        return;
//      }
//      root[p] = q;
//      count--;
//    }
//  }
//}

////dfs(发现朋友圈res+1，然后用dfs将该朋友圈的所有1改为0)
//class Solution {
//
//  public int findCircleNum(int[][] M) {
//    if (M == null || M.length == 0 || M[0] == null || M[0].length == 0) {
//      return 0;
//    }
//    int res = 0;
//    for (int i = 0; i < M.length; i++) {
//      for (int j = 0; j < M[0].length; j++) {
//        if (M[i][j] == 1) {
//          res++;
//          dfs(M, i, j);
//        }
//      }
//    }
//    return res;
//  }
//
//  private void dfs(int[][] M, int x, int y) {
//    int m = M.length, n = M[0].length;
//    if (x < 0 || x >= m || y < 0 || y >= n) {
//      return;
//    }
////将x和y的朋友关系改为0
//    M[x][y] = 0;
////遍历y的朋友，进行dfs
//    for (int i = 0; i < m; i++) {
//      if (M[i][y] == 1) {
//        dfs(M, i, y);
//      }
//    }
////遍历x的朋友，进行dfs
//    for (int j = 0; j < n; j++) {
//      if (M[x][j] == 1) {
//        dfs(M, x, j);
//      }
//    }
//  }
//}