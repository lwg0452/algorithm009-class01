import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class Solution {

  Map<Integer, Integer> map;

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    map = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
      map.put(inorder[i], i);
    }
    return build(preorder, 0, preorder.length - 1, 0, inorder.length - 1);
  }

  private TreeNode build(int[] preorder, int preStart, int preEnd, int inStart, int inEnd) {
    if (preStart > preEnd || inStart > inEnd) {
      return null;
    }
    TreeNode root = new TreeNode(preorder[preStart]);
    int index = map.get(preorder[preStart]);
    int leftLen = index - inStart;
    int rightLen = inEnd - index;
    root.left = build(preorder, preStart + 1, preStart + leftLen, inStart, index - 1);
    root.right = build(preorder, preStart + leftLen + 1, preEnd, index + 1, inEnd);
    return root;
  }
}