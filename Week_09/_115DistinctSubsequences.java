class Solution {

  public int numDistinct(String s, String t) {
    int[][] dp = new int[s.length() + 1][t.length() + 1];
    for (int i = 0; i <= s.length(); i++) {
      dp[i][0] = 1;
    }
    char[] cs = s.toCharArray();
    char[] ct = t.toCharArray();
    for (int i = 1; i <= s.length(); i++) {
      for (int j = 1; j <= t.length(); j++) {
        //不考虑s[i]和t[j],dp[i - 1][j]必须加上,考虑s[i]和t[j]若相等,则需要加上dp[i - 1][j - 1]
        dp[i][j] = cs[i - 1] == ct[j - 1] ? dp[i - 1][j] + dp[i - 1][j - 1] : dp[i - 1][j];
      }
    }
    return dp[s.length()][t.length()];
  }
}