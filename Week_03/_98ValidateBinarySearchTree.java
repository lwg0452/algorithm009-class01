/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class Solution {

  public boolean isValidBST(TreeNode root) {
    return isValidBST(root, null, null);
  }

  private boolean isValidBST(TreeNode root, Integer minBound, Integer maxBound) {
    if (root == null) {
      return true;
    }
    if ((minBound != null && root.val <= minBound) || (maxBound != null && root.val >= maxBound)) {
      return false;
    }
    return isValidBST(root.left, minBound, root.val) && isValidBST(root.right, root.val, maxBound);
  }
}