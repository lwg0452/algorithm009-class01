import java.util.ArrayList;
import java.util.List;

class Solution {

  public List<String> generateParenthesis(int n) {
    List<String> res = new ArrayList<>();
    if (n <= 0) {
      return res;
    }
    generate(res, "", 0, 0, n);
    return res;
  }

  private void generate(List<String> res, String curr, int left, int right, int n) {
    if (right > left || left > n) {
      return;
    }
    if (left == n && right == n) {
      res.add(curr);
      return;
    }
    if (left < n) {
      generate(res, curr + '(', left + 1, right, n);
    }
    if (right < left) {
      generate(res, curr + ')', left, right + 1, n);
    }
  }
}