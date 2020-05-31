import java.util.*;

class Solution {

  public List<List<String>> groupAnagrams(String[] strs) {
    if (strs.length == 0) {
      return new ArrayList<>();
    }
    Map<String, List> map = new HashMap<>();
    for (int i = 0; i < strs.length; i++) {
      String keyString = getKey(strs[i]);
      if (!map.containsKey(keyString)) {
        map.put(keyString, new ArrayList<String>());
        map.get(keyString).add(strs[i]);
      } else {
        map.get(keyString).add(strs[i]);
      }
    }
    return new ArrayList(map.values());
  }

  public String getKey(String str) {
    char[] key = new char[26];
    for (char c : str.toCharArray()) {
      key[c - 'a']++;
    }
    return new String(key);
  }
}
