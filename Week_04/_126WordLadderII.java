import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {

  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    List<List<String>> res = new LinkedList<>();
    Set<String> wordSet = new HashSet<>(wordList);
    if (!wordSet.contains(endWord)) {
      return res;
    }
    Set<String> beginSet = new HashSet<>();
    Set<String> endSet = new HashSet<>();
    beginSet.add(beginWord);
    endSet.add(endWord);
    Map<String, List<String>> map = new HashMap<>();
    bfs(beginSet, endSet, wordSet, map, false);

    List<String> list = new ArrayList<>();
    list.add(beginWord);
    dfs(res, list, beginWord, endWord, map);
    return res;
  }

  //reverse == false start -> end,  reverse == true end -> start
  private void bfs(Set<String> beginSet, Set<String> endSet, Set<String> wordSet,
      Map<String, List<String>> map, boolean reverse) {
    if (beginSet.isEmpty()) {
      return;
    }
    if (beginSet.size() > endSet.size()) {
      bfs(endSet, beginSet, wordSet, map, !reverse);
      return;
    }

    boolean finish = false;
    Set<String> next = new HashSet<>();
    wordSet.removeAll(beginSet);
    for (String str : beginSet) {
      char[] chars = str.toCharArray();
      for (int i = 0; i < chars.length; i++) {
        char old = chars[i];
        for (char c = 'a'; c <= 'z'; c++) {
          chars[i] = c;
          String test = new String(chars);
          if (wordSet.contains(test)) {
            if (endSet.contains(test)) {  //到达终点
              finish = true;
            } else {                      //没到终点，还要继续
              next.add(test);
            }

            String key = reverse ? test : str;
            String value = reverse ? str : test;

            if (!map.containsKey(key)) {
              map.put(key, new ArrayList<>());
            }
            map.get(key).add(value);
          }
        }
        chars[i] = old;
      }
    }

    if (!finish) {
      bfs(next, endSet, wordSet, map, reverse);
    }
  }

  private void dfs(List<List<String>> res, List<String> list, String curr, String endWord,
      Map<String, List<String>> map) {
    if (curr.equals(endWord)) {
      res.add(new ArrayList<>(list));
      return;
    }
    if (!map.containsKey(curr)) {
      return;
    }
    List<String> next = map.get(curr);
    for (String str : next) {
      list.add(str);
      dfs(res, list, str, endWord, map);
      list.remove(list.size() - 1);
    }
  }
}