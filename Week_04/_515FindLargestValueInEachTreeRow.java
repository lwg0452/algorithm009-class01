import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
//dfs
class Solution {

  public List<Integer> largestValues(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    dfs(res, 0, root);
    return res;
  }

  private void dfs(List<Integer> res, int level, TreeNode root) {
    if (root == null) {
      return;
    }

    if (level == res.size()) {
      res.add(root.val);
    } else {
      res.set(level, Math.max(root.val, res.get(level)));
    }
    dfs(res, level + 1, root.left);
    dfs(res, level + 1, root.right);
  }
}

//bfs
//class Solution {
//
//  public List<Integer> largestValues(TreeNode root) {
//    List<Integer> res = new ArrayList<>();
//    if (root == null) {
//      return res;
//    }
//
//    Queue<TreeNode> queue = new LinkedList<>();
//    queue.offer(root);
//    while (!queue.isEmpty()) {
//      int size = queue.size();
//      int temp = Integer.MIN_VALUE;
//      for (int i = 0; i < size; i++) {
//        TreeNode node = queue.poll();
//        temp = Math.max(temp, node.val);
//        if (node.left != null) {
//          queue.offer(node.left);
//        }
//        if (node.right != null) {
//          queue.offer(node.right);
//        }
//      }
//      res.add(temp);
//    }
//    return res;
//  }
//}
