# 字典树 Trie   
## 基本结构
字典树，即 Trie 树，又称单词查找树或键树，是一种树形结构。典型应用是用于统计和排序大量的字符串（但不仅限于字符串），所以经常被搜索引
擎系统用于文本词频统计。它的优点是：最大限度地减少无谓的字符串比较，查询效率比哈希表高。
## 基本性质
1.结点本身不存完整单词；    
2.从根结点到某一结点，路径上经过的字符连接起来，为该结点对应的字符串；    
3.每个结点的所有子结点路径代表的字符都不相同。    
## 核心思想
Trie 树的核心思想是空间换时间。利用字符串的公共前缀来降低查询时间的开销以达到提高效率的目的。
## Trie树实现
```
class Trie {

  TrieNode root;

  //Initialize
  public Trie() {
    root = new TrieNode();
  }

  //Inserts a word into the trie.
  public void insert(String word) {
    TrieNode p = root;
    for (char c : word.toCharArray()) {
      if (p.children[c - 'a'] == null) {
        p.children[c - 'a'] = new TrieNode();
      }
      p = p.children[c - 'a'];
    }
    p.isWord = true;
  }

  //Returns if the word is in the trie.
  public boolean search(String word) {
    TrieNode p = root;
    for (char c : word.toCharArray()) {
      p = p.children[c - 'a'];
      if (p == null) {
        return false;
      }
    }
    return p.isWord;
  }

  //Returns if there is any word in the trie that starts with the given prefix.
  public boolean startsWith(String prefix) {
    TrieNode p = root;
    for (char c : prefix.toCharArray()) {
      p = p.children[c - 'a'];
      if (p == null) {
        return false;
      }
    }
    return true;
  }

  class TrieNode {

    TrieNode[] children;
    boolean isWord;

    public TrieNode() {
      children = new TrieNode[26];
      isWord = false;
    }
  }
}
```

# 并查集 Disjoint Set
## 适用场景
1.组团、配对问题    
2.Group or not
## Java实现
```
  class UnionFind {

    int[] parents;

    public UnionFind(int n) {
      parents = new int[n];
      for (int i = 0; i < n; i++) {
        parents[i] = i;
      }
    }

    public int find(int p) {
      while (parents[p] != p) {
        parents[p] = parents[parents[p]];
        p = parents[p];
      }
      return p;
    }

    public void union(int p, int q) {
      p = find(p);
      q = find(q);
      if (p == q) {
        return;
      }
      parents[p] = q;
    }

    public boolean isConnected(int p, int q) {
      return find(p) == find(q);
    }
  }
```    
# 高级搜索
## 初级搜索
1. 朴素搜索    
2. 优化思路：不重复&nbsp;&nbsp;剪枝    
3. 搜索方向：dfs&nbsp;&nbsp;bfs    
## 双向bfs模板
```
def dBFS(graph, start, end):
    visited = set()
    front = []
    back = []
    front.append(start)
    back.append(end)
    while front and back:
        nodes = set()
        for node in front:
            visited.add(node) #加入访问
            process(node) # 处理当前node
            nodes.append(generate_related_nodes(node)) #获取子节点
        front = nodes
        # 从较小的set开始
        if len(back) < len(front):
            front, back = back, front
```
## A*算法
通过使用估值函数加速搜索过程
### 启发式函数h(n)
它用来评价哪些结点最有希望的是一个我们要找的结点，h(n) 会返回一个非负实数,也可以认为是从结点n的目标结点路径的估计成本。
### A*算法模板
```
def AstarSearch(graph, start, end):

    pq = collections.priority_queue() #优先级—>估价函数
    pq.append([start])
    visited.add(start)

    while pq:
        node = pq.pop() # can we add more intelligence here ?
        visited.add(node)

        process(node)
        nodes = generate_related_nodes(node)
        unvisited = [node for node in nodes if node not in visited]
        pq.push(unvisited)
```
# AVL树（平衡二叉搜索树）
Balance Factor（平衡因子）是它的左子树的高度减去它的右子树的高度（有时相反）。balance factor = {-1, 0, 1}
## 插入时通过四种操作来平衡
左左树：右旋    
右右树：左旋
左右树：先左旋，再右旋
右左树：先右旋，再左旋
# 红黑树
## 关键性质
从根到叶子的最长的可能路径不多于最短的可能路径的两倍长。
## 红黑树须满足如下五个条件
红黑树是一种近似平衡的二叉搜索树（Binary Search Tree），它能够确保任何一个结点的左右子树的高度差小于两倍。具体来说，红黑树是满足如下条件的二叉搜索树：    
• 每个结点要么是红色，要么是黑色    
• 根节点是黑色    
• 每个叶节点（NIL节点，空节点）是黑色的。    
• 不能有相邻接的两个红色节点    
• 从任一节点到其每个叶子的所有路径都包含相同数目的黑色节点。    