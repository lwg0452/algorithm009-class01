import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

//使用dfs求解（每次处理一层（一个碱基突变），level++）
class Solution {

  public int minMutation(String start, String end, String[] bank) {
    if (start.equals(end)) {
      return 0;
    }
    int res = 0;
    Set<String> visited = new HashSet<>();
    Set<String> bankSet = new HashSet<>();
    for (String str : bank) {
      bankSet.add(str);
    }
    char[] charSet = {'A', 'T', 'G', 'C'};
    Queue<String> queue = new LinkedList<>();
    queue.offer(start);

    while (!queue.isEmpty()) {
      res++;
      int count = queue.size();
      for (int i = 0; i < count; i++) {
        String str = queue.poll();
        if (visited.contains(str)) {
          continue;
        }
        char[] chars = str.toCharArray();
        for (int j = 0; j < chars.length; j++) {
          char old = chars[j];
          for (char c : charSet) {
            chars[j] = c;
            String test = new String(chars);
            if (visited.contains(test) || !bankSet.contains(test)) {
              continue;
            }
            if (test.equals(end)) {
              return res;
            }
            queue.offer(test);
          }
          chars[j] = old;
        }
        visited.add(str);
      }
    }
    return -1;
  }
}