/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

import java.util.ArrayList;
import java.util.List;

class Solution {

  public List<List<Integer>> levelOrder(Node root) {
    List<List<Integer>> res = new ArrayList<>();
    dfs(root, 0, res);
    return res;
  }

  private void dfs(Node root, int currentLevel, List<List<Integer>> res) {
    if (root == null) {
      return;
    }
    if (res.size() <= currentLevel) {
      res.add(new ArrayList<>());
    }
    res.get(currentLevel).add(root.val);
    for (Node child : root.children) {
      dfs(child, currentLevel + 1, res);
    }
    return;
  }
}