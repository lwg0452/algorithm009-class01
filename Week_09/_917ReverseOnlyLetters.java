class Solution {

  public String reverseOnlyLetters(String S) {
    char[] str = S.toCharArray();
    int l = 0, r = S.length() - 1;
    while (l < r) {
      while (l < r && !Character.isLowerCase(str[l]) && !Character.isUpperCase(str[l])) {
        l++;
      }
      while (l < r && !Character.isLowerCase(str[r]) && !Character.isUpperCase(str[r])) {
        r--;
      }
      if (l == r) {
        break;
      }
      char temp = str[l];
      str[l++] = str[r];
      str[r--] = temp;
    }
    return new String(str);
  }
}