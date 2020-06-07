import java.util.ArrayList;
import java.util.List;

class Solution {

  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> res = new ArrayList<>();
    helper(1, n, k, new ArrayList<Integer>(), res);
    return res;
  }

  private void helper(int start, int n, int k, List<Integer> list, List<List<Integer>> res) {
    //terminator
    if (k == 0) {
      res.add(new ArrayList<>(list));
      return;
    }
    for (int i = start; i <= n - k + 1; i++) {
      //process current logic
      list.add(i);
      //drill down
      helper(i + 1, n, k - 1, list, res);
      //restore current status
      list.remove(list.size() - 1);
    }
  }
}
