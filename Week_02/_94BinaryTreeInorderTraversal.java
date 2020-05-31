import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class Solution {

  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    inorderTraversal(root, res);
    return res;
  }

  private void inorderTraversal(TreeNode root, List<Integer> res) {
    if (root == null) {
      return;
    }
    inorderTraversal(root.left, res);
    res.add(root.val);
    inorderTraversal(root.right, res);
    return;
  }
}
