import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class Solution {

  Set<Integer> col;  //y
  Set<Integer> pie;  //x + y
  Set<Integer> na;   //x - y

  public List<List<String>> solveNQueens(int n) {
    if (n <= 0) {
      return new ArrayList<>();
    }
    col = new HashSet<>();
    pie = new HashSet<>();
    na = new HashSet<>();
    List<List<String>> res = new LinkedList<>();
    dfs(res, new int[n][n], 0, n);
    return res;
  }

  private void dfs(List<List<String>> res, int[][] curr, int level, int n) {
    if (level == n) {
      res.add(format(curr));
    }

    for (int i = 0; i < n; i++) {
      if (col.contains(i) || pie.contains(level + i) || na.contains(level - i)) {
        continue;
      }
      curr[level][i] = 1;
      col.add(i);
      pie.add(level + i);
      na.add(level - i);
      dfs(res, curr, level + 1, n);
      curr[level][i] = 0;
      col.remove(i);
      pie.remove(level + i);
      na.remove(level - i);
    }
  }

  private List<String> format(int[][] grid) {
    List<String> res = new ArrayList<>();
    for (int i = 0; i < grid.length; i++) {
      StringBuilder builder = new StringBuilder();
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 0) {
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