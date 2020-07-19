class Solution {

  public boolean isIsomorphic(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    int[] dict1 = new int[256], dict2 = new int[256];
    for (int i = 0; i < s.length(); i++) {
      if (dict1[s.charAt(i)] != dict2[t.charAt(i)]) {
        return false;
      }
      dict1[s.charAt(i)] = dict2[t.charAt(i)] = i + 1;
    }
    return true;
  }
}