/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
//class Solution {
//
//  public int minDepth(TreeNode root) {
//    if (root == null) {
//      return 0;
//    }
//    return minDepth(root, 0, Integer.MAX_VALUE);
//  }
//
//  private int minDepth(TreeNode root, int currentLevel, int minLevel) {
//    if (root == null) {
//      return minLevel;
//    }
//    currentLevel++;
//    if (root.left == null && root.right == null) {
//      minLevel = Math.min(currentLevel, minLevel);
//    }
//    return Math.min(minDepth(root.left, currentLevel, minLevel),
//        minDepth(root.right, currentLevel, minLevel));
//  }
//}

class Solution {

  public int minDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    if (root.left == null) {
      return 1 + minDepth(root.right);
    }
    if (root.right == null) {
      return 1 + minDepth(root.left);
    }
    return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
  }
}