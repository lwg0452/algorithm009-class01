import java.util.LinkedList;
import java.util.List;

class Solution {

  public List<String> generateParenthesis(int n) {
    List<String> res = new LinkedList<>();
    helper(res, "", 0, 0, n);
    return res;
  }

  private void helper(List<String> res, String str, int left, int right, int n) {
    if (right > left) {
      return;
    }
    if (left < n) {
      helper(res, str + '(', left + 1, right, n);
    }
    if (right < left) {
      helper(res, str + ')', left, right + 1, n);
    }
    if (left == n && right == n) {
      res.add(str);
    }
  }
}