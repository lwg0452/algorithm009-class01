import java.util.Deque;
import java.util.LinkedList;

class Solution {

  public int largestRectangleArea(int[] heights) {
    if (heights == null || heights.length == 0) {
      return 0;
    }
    int max = 0;
    Deque<Integer> stack = new LinkedList<>();
    stack.push(-1);
    for (int i = 0; i < heights.length; i++) {
      while (stack.peek() != -1 && heights[i] < heights[stack.peek()]) {
        max = Math.max(max, heights[stack.pop()] * (i - stack.peek() - 1));
      }
      stack.push(i);
    }
    while (stack.peek() != -1) {
      max = Math.max(max, heights[stack.pop()] * (heights.length - stack.peek() - 1));
    }
    return max;
  }
}