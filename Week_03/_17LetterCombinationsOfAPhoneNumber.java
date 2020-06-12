import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution {

  Map<Character, String> map;

  public List<String> letterCombinations(String digits) {
    if (digits == null || digits.length() == 0) {
      return new ArrayList<>();
    }
    map = new HashMap<>();
    map.put('2', "abc");
    map.put('3', "def");
    map.put('4', "ghi");
    map.put('5', "jkl");
    map.put('6', "mno");
    map.put('7', "pqrs");
    map.put('8', "tuv");
    map.put('9', "wxyz");
    List<String> res = new LinkedList<>();
    StringBuilder builder = new StringBuilder();
    helper(res, builder, 0, digits);
    return res;
  }

  private void helper(List<String> res, StringBuilder builder, int index, String digits) {
    if (index == digits.length()) {
      res.add(builder.toString());
      return;
    }

    String temp = map.get(digits.charAt(index));
    for (char c : temp.toCharArray()) {
      builder.append(c);
      helper(res, builder, index + 1, digits);
      builder.deleteCharAt(index);
    }
  }
}