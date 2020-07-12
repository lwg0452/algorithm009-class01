import java.util.Arrays;

class Solution {

  public int[][] merge(int[][] intervals) {
    if (intervals == null || intervals.length == 0) {
      return intervals;
    }
    Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
    int[][] res = new int[intervals.length][2];
    res[0] = intervals[0];
    int index = 1;
    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i][0] > res[index - 1][1]) {
        res[index++] = intervals[i];
      } else {
        res[index - 1][1] = Math.max(res[index - 1][1], intervals[i][1]);
      }
    }
    return Arrays.copyOfRange(res, 0, index);
  }
}