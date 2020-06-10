import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {

  public List<List<Integer>> permuteUnique(int[] nums) {
    if (nums == null || nums.length == 0) {
      return new ArrayList<>();
    }
    List<List<Integer>> res = new LinkedList<>();
    Arrays.sort(nums);
    backtrack(res, new ArrayList<>(), new boolean[nums.length], nums);
    return res;
  }

  private void backtrack(List<List<Integer>> res, ArrayList<Integer> curr, boolean[] visited,
      int[] nums) {
    if (curr.size() == nums.length) {
      res.add(new ArrayList<>(curr));
    } else {
      for (int i = 0; i < nums.length; i++) {
        if (visited[i]) {
          continue;
        }
        visited[i] = true;
        curr.add(nums[i]);
        backtrack(res, curr, visited, nums);
        curr.remove(curr.size() - 1);
        visited[i] = false;
        while (i + 1 < nums.length && nums[i + 1] == nums[i]) {
          i++;
        }
      }
    }
  }
}