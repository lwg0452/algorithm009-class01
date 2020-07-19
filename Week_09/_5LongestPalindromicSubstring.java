class Solution {

  public String longestPalindrome(String s) {
    if (s.length() < 2) {
      return s;
    }
    char[] str = s.toCharArray();
    int n = s.length(), start = 0, end = 0;
    boolean[][] dp = new boolean[n][n];
    for (int len = 1; len <= n; len++) {
      for (int l = 0; l <= n - len; l++) {
        int r = l + len - 1;
        if (str[l] == str[r] && (r - l <= 2 || dp[l + 1][r - 1])) {
          dp[l][r] = true;
          end = r;
          start = l;
        }
      }
    }
    return s.substring(start, end + 1);
  }
}