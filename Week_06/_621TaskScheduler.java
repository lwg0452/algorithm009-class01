import java.util.Arrays;

//Math.max((n + 1) * (count[25] - 1) + (25 - i), tasks.length)
//每轮n+1，最多完成n+1个不同的任务，出现次数最多的任务需要count[25]轮
//前count[25] - 1轮每轮需要的时间为n + 1
//特殊的是最后一轮，需要的时间为剩余需要完成的任务数
class Solution {

  public int leastInterval(char[] tasks, int n) {
    if (tasks == null || tasks.length == 0) {
      return 0;
    }
    int[] count = new int[26];
    for (char c : tasks) {
      count[c - 'A']++;
    }
    Arrays.sort(count); //排序，出现次数最多的任务是count[25]
    int i = 25; //i用来记录最后一个出现次数为count[25]的任务的位置
    while (i >= 0 && count[i] == count[25]) {
      i--;
    }
    return Math.max((n + 1) * (count[25] - 1) + (25 - i), tasks.length);
  }
}

//优先队列
//class Solution {
//
//  public int leastInterval(char[] tasks, int n) {
//    if (tasks == null || tasks.length == 0) {
//      return 0;
//    }
//    int[] count = new int[26];
//    for (char c : tasks) {
//      count[c - 'A']++;
//    }
//    PriorityQueue<Integer> priority = new PriorityQueue<>(26, Collections.reverseOrder());
//    for (int i : count) {
//      if (i != 0) {
//        priority.add(i);
//      }
//    }
//    int res = 0;
//    while (!priority.isEmpty()) {
//      int i = 0;
//      List<Integer> temp = new ArrayList<>();
//      while (i <= n) {
//        if (!priority.isEmpty()) {
//          if (priority.peek() > 1) {
//            temp.add(priority.poll() - 1);
//          } else {
//            priority.poll();
//          }
//        }
//        res++;
//        i++;
//        if (priority.isEmpty() && temp.isEmpty()) {
//          break;
//        }
//      }
//      for (Integer integer : temp) {
//        priority.add(integer);
//      }
//    }
//    return res;
//  }
//}

//基于排序
//class Solution {
//
//  public int leastInterval(char[] tasks, int n) {
//    if (tasks == null || tasks.length == 0) {
//      return 0;
//    }
//    int[] count = new int[26];
//    for (char c : tasks) {
//      count[c - 'A']++;
//    }
//    Arrays.sort(count);
//    int res = 0;
//    while (count[25] > 0) {
//      int i = 0;
//      while (i <= n) {
//        if (count[25] == 0) {
//          break;
//        }
//        if (i <= 25 && count[25 - i] > 0) {
//          count[25 - i]--;
//        }
//        res++;
//        i++;
//      }
//      Arrays.sort(count);
//    }
//    return res;
//  }
//}