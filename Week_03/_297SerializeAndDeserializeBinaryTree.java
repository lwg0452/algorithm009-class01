import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
public class Codec {

  // Encodes a tree to a single string.
  public java.lang.String serialize(TreeNode root) {
    StringBuilder builder = new StringBuilder();
    serialize(root, builder);
    return builder.toString();
  }

  private void serialize(TreeNode root, StringBuilder builder) {
    if (root == null) {
      builder.append('N').append(',');
    } else {
      builder.append(root.val).append(',');
      serialize(root.left, builder);
      serialize(root.right, builder);
    }
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
    return buildTree(queue);
  }

  private TreeNode buildTree(Queue<String> queue) {
    String val = queue.poll();
    if (val.equals("N")) {
      return null;
    }
    TreeNode root = new TreeNode(Integer.parseInt(val));
    root.left = buildTree(queue);
    root.right = buildTree(queue);
    return root;
  }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));