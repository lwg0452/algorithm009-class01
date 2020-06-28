package dynamic.programming._91DecodeWays;

class Solution {

  public int numDecodings(String s) {
    if (s == null || s.length() == 0 || s.charAt(0) == '0') {
      return 0;
    }
    int[] dp = new int[s.length() + 1];
    dp[0] = 1;
    dp[1] = 1;
    for (int i = 2; i <= s.length(); i++) {
      int one = Integer.valueOf(s.substring(i - 1, i)); //一位数字
      int two = Integer.valueOf(s.substring(i - 2, i)); //两位数字
      if (one != 0) {
        dp[i] += dp[i - 1];
      }
      if (10 <= two && two <= 26) {
        dp[i] += dp[i - 2];
      }
    }
    return dp[s.length()];
  }
}