import java.util.HashSet;
import java.util.Set;

class Solution {

  int[] dx = {0, 1, 0, -1};
  int[] dy = {1, 0, -1, 0};

  public int robotSim(int[] commands, int[][] obstacles) {
    int res = 0;
    int direction = 0;
    int x = 0, y = 0;
    Set<Long> obstaclesSet = new HashSet<>();
    for (int i = 0; i < obstacles.length; i++) {
      //最大值30000 左移15位就够了
      obstaclesSet.add(((long) obstacles[i][0] << 15) + (long) obstacles[i][1]);
    }

    for (int i = 0; i < commands.length; i++) {
      if (commands[i] == -2) {
        direction = (3 + direction) % 4;
      } else if (commands[i] == -1) {
        direction = (1 + direction) % 4;
      } else {
        for (int j = 0; j < commands[i]; j++) {
          if (obstaclesSet
              .contains(((long) (x + dx[direction]) << 15) + (long) (y + dy[direction]))) {
            continue;
          }
          x += dx[direction];
          y += dy[direction];
          res = Math.max(res, x * x + y * y);
        }
      }
    }
    return res;
  }
}