import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

  public List<Integer> findAnagrams(String s, String p) {
    List<Integer> res = new ArrayList<>();
    int[] count = new int[26], test = new int[26];
    for (char c : p.toCharArray()) {
      count[c - 'a']++;
    }
    char[] str = s.toCharArray();
    for (int i = 0; i < s.length(); i++) {
      test[str[i] - 'a']++;
      if (i >= p.length() - 1) {
        if (Arrays.equals(count, test)) {
          res.add(i + 1 - p.length());
        }
        test[str[i + 1 - p.length()] - 'a']--;
      }
    }
    return res;
  }
}