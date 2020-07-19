class Solution {

  public String reverseWords(String s) {
    String[] words = s.split(" +");
    StringBuilder builder = new StringBuilder();
    for (int i = words.length - 1; i >= 0; i--) {
      builder.append(words[i] + " ");
    }
    return builder.toString().trim();
  }
}