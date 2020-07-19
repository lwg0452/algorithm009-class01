class Solution {

  public boolean validPalindrome(String s) {
    if (s == null || s.length() < 3) {
      return true;
    }
    char[] str = s.toCharArray();
    int l = 0, r = s.length() - 1;
    while (l < r) {
      if (str[l] != str[r]) {
        return isPalindrome(str, l, r - 1) || isPalindrome(str, l + 1, r);
      }
      l++;
      r--;
    }
    return true;
  }

  private boolean isPalindrome(char[] str, int l, int r) {
    while (l < r) {
      if (str[l++] != str[r--]) {
        return false;
      }
    }
    return true;
  }
}