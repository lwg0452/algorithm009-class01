import java.util.ArrayList;
import java.util.List;

class Solution {

  int[] dx = {-1, 1, 0, 0};
  int[] dy = {0, 0, 1, -1};

  public List<String> findWords(char[][] board, String[] words) {
    List<String> res = new ArrayList<>();
    //参数检查
    if (board == null || board.length == 0 || board[0] == null || board[0].length == 0
        || words == null || words.length == 0) {
      return res;
    }
    //构造字典树
    TrieNode trie = new TrieNode();
    for (String word : words) {
      insertToTrie(trie, word);
    }
    //dfs
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        dfs(board, trie, i, j, res);
      }
    }
    //返回
    return res;
  }

  //dfs,单词被查到就将word置为null（去重）
  private void dfs(char[][] board, TrieNode trie, int x, int y, List<String> res) {
    int m = board.length, n = board[0].length;
    //参数检查 terminator
    if (x < 0 || x >= m || y < 0 || y >= n || trie == null || board[x][y] == '$') {
      return;
    }
    //字典树中不存在这样的前缀，返回
    TrieNode p = trie.children[board[x][y] - 'a'];
    if (p == null) {
      return;
    }
    //查到单词 process current level
    if (p.word != null) {
      res.add(p.word);
      p.word = null;
    }
    //每个字母只能使用一次
    char temp = board[x][y];
    board[x][y] = '$';
    //drill down
    for (int i = 0; i < 4; i++) {
      dfs(board, p, x + dx[i], y + dy[i], res);
    }
    //restore current status
    board[x][y] = temp;
  }

  //构造以trie为根的字典树，将一个单词插入字典树
  private void insertToTrie(TrieNode trie, String word) {
    TrieNode p = trie;
    for (char c : word.toCharArray()) {
      if (p.children[c - 'a'] == null) {
        p.children[c - 'a'] = new TrieNode();
      }
      p = p.children[c - 'a'];
    }
    p.word = word;
  }

  //树节点
  class TrieNode {

    TrieNode[] children;
    String word;

    public TrieNode() {
      children = new TrieNode[26];
    }
  }
}