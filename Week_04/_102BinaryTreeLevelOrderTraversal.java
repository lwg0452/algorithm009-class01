import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
//dfs
//class Solution {
//
//  public List<List<Integer>> levelOrder(TreeNode root) {
//    List<List<Integer>> res = new LinkedList<>();
//    dfs(res, 0, root);
//    return res;
//  }
//
//  private void dfs(List<List<Integer>> res, int level, TreeNode root) {
//    if (root == null) {
//      return;
//    }
//    if (level == res.size()) {
//      List<Integer> list = new ArrayList<>();
//      list.add(root.val);
//      res.add(list);
//    } else {
//      res.get(level).add(root.val);
//    }
//    dfs(res, level + 1, root.left);
//    dfs(res, level + 1, root.right);
//  }
//}

//bfs
class Solution {

  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> res = new LinkedList<>();
    if (root == null) {
      return res;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      int len = queue.size();
      List<Integer> list = new ArrayList<>();
      for (int i = 0; i < len; i++) {
        TreeNode node = queue.poll();
        list.add(node.val);
        if (node.left != null) {
          queue.offer(node.left);
        }
        if (node.right != null) {
          queue.offer(node.right);
        }
      }
      res.add(list);
    }
    return res;
  }
}