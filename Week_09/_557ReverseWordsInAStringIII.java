class Solution {

  public String reverseWords(String s) {
    String[] words = s.split(" ");
    StringBuilder builder = new StringBuilder();
    for (String word : words) {
      builder.append(reverseWord(word));
      builder.append(' ');
    }
    return builder.toString().trim();
  }

  private char[] reverseWord(String word) {
    char[] chars = word.toCharArray();
    int l = 0, r = word.length() - 1;
    while (l < r) {
      char temp = chars[l];
      chars[l++] = chars[r];
      chars[r--] = temp;
    }
    return chars;
  }
}