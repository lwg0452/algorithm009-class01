class Solution {

  public int numDecodings(String s) {
    int[] dp = new int[s.length() + 1];
    dp[0] = 1;
    dp[1] = s.charAt(0) == '0' ? 0 : 1;
    for (int i = 2; i <= s.length(); i++) {
      if (s.charAt(i - 1) != '0') {
        dp[i] += dp[i - 1];
      } else if (s.charAt(i - 2) != '1' && s.charAt(i - 2) != '2') {
        return 0;
      }
      int two = (s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0';
      dp[i] += two < 10 || two > 26 ? 0 : dp[i - 2];
    }
    return dp[s.length()];
  }
}