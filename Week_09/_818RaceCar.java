import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;


//DP
//连续n个加速指令后，车的位置为 newPos = oldPos + (1 << n) - 1
//从0开始连续n个加速指令后，会有三种情况：
//1.到达target
//2.越过target，需要调头
//3.没到target
//
//从pos == 0开始dp，先进行forward次加速，我们希望越来越接近当前的target,由此可以第一次剪枝 ———— i，所以
// 1)没越过i  0 < (1 << forward) - 1 <= i
// 2)越过i    i < (1 << forward) - 1 < 2*i
//
//第二次剪枝：在没越过i时，只有当加速一次越过i时，才回退
class Solution {

  public int racecar(int target) {
    int[] dp = new int[target + 1];
    for (int i = 1; i <= target; i++) {
      dp[i] = Integer.MAX_VALUE;
      for (int forward = 1; (1 << forward) - 1 < 2 * i; forward++) {
        int len = (1 << forward) - 1;
        if (len == i) {
          dp[i] = forward;
        } else if (len > i) {
          dp[i] = Math.min(dp[i], forward + 1 + dp[len - i]);
        } else if ((1 << (forward + 1)) - 1 > i) {  //剪枝
          for (int back = 0; back < forward; back++) {
            dp[i] = Math.min
                (dp[i], forward + 1 + back + 1 + dp[i - len + (1 << back) - 1]);
          }
        }
      }
    }
    return dp[target];
  }
}

//class Solution {
//
//  //bfs
//  public int racecar(int target) {
//    Queue<int[]> queue = new LinkedList<>();
//    queue.offer(new int[]{0, 1});
//    HashSet<String> visited = new HashSet<>();
//    visited.add('0' + " " + '1');
//    for (int level = 0; !queue.isEmpty(); level++) {
//      for (int i = queue.size(); i > 0; i--) {
//        int[] curr = queue.poll();
//        if (curr[0] == target) {
//          return level;
//        }
//        int[] next1 = new int[]{curr[0] + curr[1], curr[1] << 1};
//        String str1 = next1[0] + " " + next1[1];
//        if (!visited.contains(str1) && next1[0] > 0 && next1[0] < (target << 1)) {  //?
//          queue.offer(next1);
//          visited.add(str1);
//        }
//        int[] next2 = new int[]{curr[0], curr[1] > 0 ? -1 : 1};
//        String str2 = next2[0] + " " + next2[1];
//        if (!visited.contains(str2) && next2[0] > 0 && next2[0] < (target << 1)) {  //?
//          queue.offer(next2);
//          visited.add(str2);
//        }
//      }
//    }
//    return -1;
//  }
//}

