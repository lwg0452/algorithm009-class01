package dynamic.programming._32LongestValidParentheses;

//DP
class Solution {

  public int longestValidParentheses(String s) {
    if (s == null || s.length() < 2) {
      return 0;
    }
    int res = 0;
    char[] str = s.toCharArray();
    int[] dp = new int[s.length() + 1];
    for (int i = 2; i <= s.length(); i++) {
      if (str[i - 1] == ')' && i - dp[i - 1] - 2 >= 0) {
        dp[i] = str[i - dp[i - 1] - 2] == '(' ? 2 + dp[i - 1] + dp[i - dp[i - 1] - 2] : 0;
        res = Math.max(res, dp[i]);
      }
    }
    return res;
  }
}

//import java.util.Deque;
//import java.util.LinkedList;
////栈
//class Solution {
//
//  public int longestValidParentheses(String s) {
//    if (s == null || s.length() < 2) {
//      return 0;
//    }
//    int res = 0;
//    char[] str = s.toCharArray();
//    Deque<Integer> stack = new LinkedList<>();
//    stack.push(-1);
//    for (int i = 0; i < str.length; i++) {
//      if (str[i] == '(') { //左括号下标进栈
//        stack.push(i);
//      } else {
//        stack.pop();
//        if (stack.isEmpty()) { //这个右括号没有与之匹配的左括号
//          stack.push(i);
//        } else {
//          res = Math.max(res, i - stack.peek());
//        }
//      }
//    }
//    return res;
//  }
//}

////O(1)空间复杂度
//class Solution {
//
//  public int longestValidParentheses(String s) {
//    if (s == null || s.length() < 2) {
//      return 0;
//    }
//    int res = 0, left = 0, right = 0;
//    for (int i = 0; i < s.length(); i++) {
//      if (s.charAt(i) == '(') {
//        left++;
//      } else {
//        right++;
//        if (left == right) {
//          res = Math.max(res, left << 1);
//        } else if (right > left) {
//          left = 0;
//          right = 0;
//        }
//      }
//    }
//    left = 0;
//    right = 0;
//    for (int i = s.length() - 1; i >= 0; i--) {
//      if (s.charAt(i) == ')') {
//        right++;
//      } else {
//        left++;
//        if (left == right) {
//          res = Math.max(res, left << 1);
//        } else if (left > right) {
//          left = 0;
//          right = 0;
//        }
//      }
//    }
//    return res;
//  }
//}
