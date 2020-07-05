import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    if (wordList.isEmpty() || beginWord.length() != endWord.length()) {
      return 0;
    }
    Set<String> dict = new HashSet<>();
    for (String str : wordList) {
      dict.add(str);
    }
    if (!dict.contains(endWord)) {
      return 0;
    }
    Set<String> beginSet = new HashSet<>();
    Set<String> endSet = new HashSet<>();
    Set<String> visited = new HashSet<>();
    beginSet.add(beginWord);
    endSet.add(endWord);
    return bfs(beginSet, endSet, dict, visited, 2);
  }

  //beginSet -> endSet 用visited记录已访问单词
  //若beginSet.size() > endSet.size()则交换beginSet和endSet，加速搜索
  //1.枚举beginSet中的单词
  //2.枚举单词中的每一个字母
  //3.将字母用a-z替换
  //4.替换后形成的新单词若在endSet中则返回res，否则将单词加入到next集合中
  //5.枚举完beginSet无结果则进行新一轮搜索
  private int bfs(Set<String> beginSet, Set<String> endSet, Set<String> dict, Set<String> visited,
      int res) {
    if (beginSet.isEmpty() || endSet.isEmpty()) {
      return 0;
    }
    if (beginSet.size() > endSet.size()) {
      return bfs(endSet, beginSet, dict, visited, res);
    }
    Set<String> next = new HashSet<>();
    for (String str : beginSet) {
      char[] chars = str.toCharArray();
      for (int i = 0; i < chars.length; i++) {
        char origin = chars[i];
        for (char c = 'a'; c <= 'z'; c++) {
          chars[i] = c;
          String test = new String(chars);
          if (visited.contains(test) || !dict.contains(test)) {
            continue;
          }
          if (endSet.contains(test)) {
            return res;
          }
          next.add(test);
        }
        chars[i] = origin;
      }
      visited.add(str);
    }
    return bfs(next, endSet, dict, visited, res + 1);
  }
}