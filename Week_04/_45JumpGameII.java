class Solution {

  public int jump(int[] nums) {
    if (nums == null || nums.length <= 1) {
      return 0;
    }
    int jumps = 1, currentEnd = nums[0], currentFarthest = nums[0];
    for (int i = 1; i < nums.length - 1; i++) {
      currentFarthest = Math.max(currentFarthest, i + nums[i]);
      if (i == currentEnd) {
        jumps++;
        currentEnd = currentFarthest;
      }
    }
    return jumps;
  }
}