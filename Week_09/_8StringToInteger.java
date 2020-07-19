class Solution {

  public int myAtoi(String str) {
    if (str == null || str.length() == 0) {
      return 0;
    }
    int index = 0, sign = 0, abs = 0;
    char[] s = str.toCharArray();
    while (index < s.length && s[index] == ' ') {
      index++;
    }
    if (index == s.length) {
      return 0;
    }
    sign = s[index] == '-' ? -1 : 1;
    if (s[index] == '+' || s[index] == '-') {
      index++;
    }
    while (index < s.length) {
      int digit = s[index++] - '0';
      if (digit < 0 || digit > 9) {
        break;
      }
      if (Integer.MAX_VALUE / 10 < abs || (Integer.MAX_VALUE / 10 == abs
          && Integer.MAX_VALUE % 10 < digit)) {
        return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
      }
      abs = abs * 10 + digit;
    }
    return sign * abs;
  }
}