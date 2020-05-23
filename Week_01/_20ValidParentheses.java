import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class Solution {

//  //栈方法 Time:O(n) Space:O(n)
//  public boolean isValid(String s) {
//    if (s == null || s.length() == 0) {
//      return true;
//    }
//    Deque<Character> stack = new LinkedList<>();
//    for (Character c : s.toCharArray()) {
//      if (c == '{') {
//        stack.push('}');
//      } else if (c == '[') {
//        stack.push(']');
//      } else if (c == '(') {
//        stack.push(')');
//      } else {
//        if (stack.isEmpty() || stack.pop() != c) {
//          return false;
//        }
//      }
//    }
//    return stack.isEmpty();
//  }

  //手工模拟栈
  public boolean isValid(String s) {
    if (s == null || s.length() == 0) {
      return true;
    }
    char test[] = new char[s.length()];
    int count = 0;
    for (char c : s.toCharArray()) {
      switch (c) {
        case '{':
          test[count++] = '}';
          break;
        case '[':
          test[count++] = ']';
          break;
        case '(':
          test[count++] = ')';
          break;
        default:
          if (count <= 0 || test[--count] != c) {
            return false;
          }
          break;
      }
    }
    return count == 0;
  }
}