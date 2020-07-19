class Solution {

  public String reverseStr(String s, int k) {
    char[] chars = s.toCharArray();
    for (int i = 0; i < s.length(); i += 2 * k) {
      int l = i, r = Math.min(chars.length - 1, i + k - 1);
      while (l < r) {
        char temp = chars[l];
        chars[l++] = chars[r];
        chars[r--] = temp;
      }
    }
    return new String(chars);
  }
}