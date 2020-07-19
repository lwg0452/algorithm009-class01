import java.util.Arrays;

class Solution {

  public int maximalRectangle(char[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return 0;
    }
    int m = matrix.length, n = matrix[0].length;
    int res = 0;
    int[] leftBound = new int[n];
    int[] rightBound = new int[n];
    int[] height = new int[n];
    Arrays.fill(rightBound, n - 1);
    for (int i = 0; i < m; i++) {
      int currLeft = 0, currRight = n - 1;
      //修改height[]
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == '1') {
          height[j]++;
        } else {
          height[j] = 0;
        }
      }

      //修改leftBound
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == '1') {
          leftBound[j] = Math.max(leftBound[j], currLeft);
        } else {
          leftBound[j] = 0; //height[j]已经==0，这里只需将legtBound[j]复位（影响的是下一层i + 1）
          currLeft = j + 1;
        }
      }

      for (int j = n - 1; j >= 0; j--) {
        if (matrix[i][j] == '1') {
          rightBound[j] = Math.min(rightBound[j], currRight);
        } else {
          rightBound[j] = n - 1; //height[j]已经==0，这里只需将legtBound[j]复位（影响的是下一层i + 1）
          currRight = j - 1;
        }
      }

      for (int j = 0; j < n; j++) {
        res = Math.max(res, (rightBound[j] - leftBound[j] + 1) * height[j]);
      }
    }
    return res;
  }
}