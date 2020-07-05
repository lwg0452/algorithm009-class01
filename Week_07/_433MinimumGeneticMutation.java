import java.util.HashSet;
import java.util.Set;

class Solution {

  char[] genes = {'A', 'T', 'C', 'G'};

  public int minMutation(String start, String end, String[] bank) {
    Set<String> dict = new HashSet<>();
    for (String str : bank) {
      dict.add(str);
    }
    if (!dict.contains(end)) {
      return -1;
    }
    Set<String> beginSet = new HashSet<>();
    Set<String> endSet = new HashSet<>();
    Set<String> visited = new HashSet<>();
    beginSet.add(start);
    endSet.add(end);
    return bfs(beginSet, endSet, dict, visited, 0);
  }

  private int bfs(Set<String> beginSet, Set<String> endSet, Set<String> dict, Set<String> visited,
      int curr) {
    if (beginSet.isEmpty()) {
      return -1;
    }
    if (beginSet.size() > endSet.size()) {
      return bfs(endSet, beginSet, dict, visited, curr);
    }
    Set<String> next = new HashSet<>();
    for (String str : beginSet) {
      char[] chars = str.toCharArray();
      for (int i = 0; i < chars.length; i++) {
        char old = chars[i];
        for (int j = 0; j < 4; j++) {
          chars[i] = genes[j];
          String test = new String(chars);
          if (!dict.contains(test) || visited.contains(test)) {
            continue;
          }
          if (endSet.contains(test)) {
            return curr + 1;
          } else {
            next.add(test);
          }
        }
        chars[i] = old;
      }
      visited.add(str);
    }
    return bfs(next, endSet, dict, visited, curr + 1);
  }
}