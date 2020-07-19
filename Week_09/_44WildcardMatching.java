class Solution {

  public boolean isMatch(String s, String p) {
    int m = s.length(), n = p.length();
    char[] cs = s.toCharArray(), cp = p.toCharArray();
    boolean[][] dp = new boolean[m + 1][n + 1];
    dp[0][0] = true;
    for (int j = 1; j <= n; j++) {
      if (cp[j - 1] == '*') {
        dp[0][j] = true;
      } else {
        break;
      }
    }
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (cs[i - 1] == cp[j - 1] || cp[j - 1] == '?') {
          dp[i][j] = dp[i - 1][j - 1];
        } else if (cp[j - 1] == '*') {
          dp[i][j] = dp[i - 1][j - 1] || dp[i][j - 1] || dp[i - 1][j];
        }
      }
    }
    return dp[m][n];
  }

}