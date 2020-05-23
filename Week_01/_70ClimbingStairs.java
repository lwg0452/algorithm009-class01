class Solution {

  //斐波那契数列 Time:O(n) Space:O(1)
  public int climbStairs(int n) {
    if (n <= 0) {
      return 0;
    }
    int pre1 = 1, pre2 = 1, res = 1;
    for (int i = 2; i <= n; i++) {
      res = pre1 + pre2;
      pre1 = pre2;
      pre2 = res;
    }
    return res;
  }
}
