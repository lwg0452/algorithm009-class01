import java.util.HashSet;
import java.util.List;
import java.util.Set;

//bfs不一定要用队列
//使beginSet, endSet两个集合不断靠近(始终从size小的集合向size大的集合靠近)
class Solution {

  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    if (beginWord.equals(endWord)) {
      return 2;
    }
    Set<String> wordSet = new HashSet<>();
    wordSet.add(beginWord);
    for (String str : wordList) {
      wordSet.add(str);
    }
    if (!wordSet.contains(endWord)) {
      return 0;
    }
    Set<String> visited = new HashSet<>();
    Set<String> begin = new HashSet<>();
    Set<String> end = new HashSet<>();
    begin.add(beginWord);
    end.add(endWord);

    return bfs(begin, end, wordSet, visited, 1);
  }

  private int bfs(Set<String> beginSet, Set<String> endSet, Set<String> wordSet,
      Set<String> visited, int len) {
    if (beginSet.isEmpty()) {
      return 0;
    }
    if (beginSet.size() > endSet.size()) {
      return bfs(endSet, beginSet, wordSet, visited, len);
    }
    Set<String> next = new HashSet<>();
    for (String str : beginSet) {
      char[] chars = str.toCharArray();
      for (int i = 0; i < chars.length; i++) {
        char old = chars[i];
        for (char c = 'a'; c <= 'z'; c++) {
          chars[i] = c;
          String test = new String(chars);
          if (!wordSet.contains(test) || visited.contains(test)) {
            continue;
          }
          if (endSet.contains(test)) {
            return len + 1;
          }
          next.add(test);
        }
        chars[i] = old;
      }
      visited.add(str);
    }

    return bfs(next, endSet, wordSet, visited, len + 1);
  }
}

//433最小基因变化的方法超时
//class Solution {
//
//  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//    if (beginWord.equals(endWord)) {
//      return 2;
//    }
//    int res = 1;
//    Set<String> wordSet = new HashSet<>();
//    for (String str : wordList) {
//      wordSet.add(str);
//    }
//    if (!wordList.contains(endWord)) {
//      return 0;
//    }
//    Set<String> visited = new HashSet<>();
//    Queue<String> queue = new LinkedList<>();
//    queue.offer(beginWord);
//
//    while (!queue.isEmpty()) {
//      res++;
//      int len = queue.size();
//      for (int i = 0; i < len; i++) {
//        String str = queue.poll();
//        char[] chars = str.toCharArray();
//        for (int j = 0; j < chars.length; j++) {
//          char old = chars[j];
//          for (char c = 'a'; c <= 'z'; c++) {
//            chars[j] = c;
//            String test = new String(chars);
//            if (!wordSet.contains(test) || visited.contains(test)) {
//              continue;
//            }
//            if (test.equals(endWord)) {
//              return res;
//            }
//            queue.offer(test);
//          }
//          chars[j] = old;
//        }
//        visited.add(str);
//      }
//    }
//    return 0;
//  }
//}