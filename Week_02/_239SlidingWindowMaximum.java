import java.util.TreeMap;

class Solution {

  public int[] maxSlidingWindow(int[] nums, int k) {
    if (nums == null || nums.length == 0) {
      return new int[0];
    }
    TreeMap<Integer, Integer> tree = new TreeMap<Integer, Integer>();
    int[] res = new int[nums.length - k + 1];
    for (int i = 0; i < nums.length; i++) {
      tree.put(nums[i], i);
      if (i >= k - 1) {
        res[i - k + 1] = tree.lastKey();
        if (tree.get(nums[i - k + 1]) == i - k + 1) {
          tree.remove(nums[i - k + 1]);
        }
      }
    }
    return res;
  }
}