package pruning._51NQueens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

  int mask;
  List<List<String>> res;

  public List<List<String>> solveNQueens(int n) {
    res = new ArrayList<>();
    if (n <= 0) {
      return res;
    }
    mask = (1 << n) - 1;
    dfs(new ArrayList<String>(), 0, 0, 0, n);
    return res;
  }

  private void dfs(List<String> curr, int col, int pie, int na, int n) {
    if (curr.size() >= n) {
      res.add(new ArrayList<>(curr));
      return;
    }
    int position = (~(col | pie | na)) & mask;
    while (position != 0) {
      char[] chars = new char[n];
      Arrays.fill(chars, '.');
      int p = position & (-position);
      chars[Integer.toBinaryString(p).length() - 1] = 'Q';
      curr.add(new String(chars));
      dfs(curr, col | p, (pie | p) << 1, (na | p) >> 1, n);
      position &= (position - 1);
      curr.remove(curr.size() - 1);
    }
  }
}

//class Solution {
//    Set<Integer> shuSet = new HashSet<>();
//    Set<Integer> pieSet = new HashSet<>();
//    Set<Integer> naSet = new HashSet<>();
//    public List<List<String>> solveNQueens(int n) {
//        List<List<String>> res = new ArrayList<>();
//        if (n <= 0) {
//            return res;
//        }
//        dfs(n,0,new int [n][n], res);
//        return res;
//    }
//
//    public void dfs(int n, int currentRow, int[][] currentBoard, List res) {
//        if (currentRow >= n) {
//            res.add(toStringList(currentBoard));
//            return;
//        }
//        for (int col = 0; col < n; col++) {
//            if (!shuSet.contains(col) && !pieSet.contains(currentRow + col) && !naSet.contains(currentRow - col)) {
//                currentBoard[currentRow][col] = 1;
//                shuSet.add(col);
//                pieSet.add(currentRow + col);
//                naSet.add(currentRow - col);
//                dfs(n, currentRow + 1, currentBoard, res);
//                currentBoard[currentRow][col] = 0;
//                shuSet.remove(col);
//                pieSet.remove(currentRow + col);
//                naSet.remove(currentRow - col);
//                continue;
//            }
//        }
//        return;
//    }
//
//    List<String> toStringList(int[][] array) {
//        List<String> list = new ArrayList<>();
//        for (int i = 0; i < array.length; i++) {
//            String str = "";
//            for (int j = 0; j < array.length; j++) {
//                if (array[i][j] == 0) {
//                    str += '.';
//                } else {
//                    str += 'Q';
//                }
//            }
//            list.add(str);
//        }
//        return list;
//    }
//}