class Solution {

  public int climbStairs(int n) {
    if (n <= 2) {
      return n;
    }
    int res = 2, pre = 1;
    for (int i = 3; i <= n; i++) {
      int temp = res;
      res = res + pre;
      pre = temp;
    }
    return res;
  }
}