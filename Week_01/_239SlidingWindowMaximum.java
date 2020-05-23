import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import sun.security.krb5.internal.KdcErrException;

class Solution {

  public int[] maxSlidingWindow(int[] nums, int k) {
    if (nums == null || nums.length < k || k <= 0) {
      return new int[0];
    }
    int len = nums.length;
    int[] res = new int[len - k + 1];
    Deque<Integer> queue = new ArrayDeque<>();
    for (int i = 0; i < len; i++) {
      //弹出不在窗口中的元素下标
      if (!queue.isEmpty() && queue.peek() < i - k + 1) {
        queue.poll();
      }
      //弹出窗口前面全部比nums[i]小的元素下标
      while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
        queue.pollLast();
      }
      queue.offer(i);
      if (i >= k - 1) {
        res[i - k + 1] = nums[queue.peek()];
      }
    }
    return res;
  }
}