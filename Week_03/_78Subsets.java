import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {

  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> res = new LinkedList<>();
    if (nums == null) {
      return res;
    }
    helper(res, new ArrayList<>(), 0, nums);
    return res;
  }

  private void helper(List<List<Integer>> res, ArrayList<Integer> curr, int index, int[] nums) {
    if (index == nums.length) {
      res.add(new ArrayList<>(curr));
      return;
    }
    helper(res, curr, index + 1, nums);
    curr.add(nums[index]);
    helper(res, curr, index + 1, nums);
    curr.remove(curr.size() - 1);
  }
}