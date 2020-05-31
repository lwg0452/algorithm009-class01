# 第二周学习笔记
## 哈希表
是根据关键码值（Key value）而直接进行访问的数据结构。
元素 ==> 散列函数 ==> 存储位置
search/delete/insert时的时间复杂度可认为是O(1)
### HashMap
key-value存储在Node[]数组中
```
static class Node<K,V> implements Map.Entry<K,V> {
    final int hash;  //每个储存元素key的哈希值
    final K key;     //key
    V value;         //value
    Node<K,V> next;  //next 追加元素时候使用，标记链表的下一个node地址
}
```
#### put方法的基本思路：
1)对key的hashCode()进行hash后计算数组下标index;
2)如果当前node[]数组为null，进行resize()初始化；
3)如果没碰撞直接放到对应下标的位置上；
4)如果碰撞了，且节点已经存在，就替换掉 value；
5)如果碰撞后发现为红黑树结构，挂载到树上。
6)如果碰撞后为链表，添加到链表尾，并判断链表如果过长(大于等于TREEIFY_THRESHOLD，默认8)，就把链表转换成红黑树结构；
7)数据 put 后，如果数据量超过threshold，就要resize。
#### get方法的基本思路：
1)对key的hashCode()进行hash计算得出数组下标index
2)下标若不存在返回null
3)判断index处元素的key是否与传入的参数相同，若相同则返回对应的value，否则发生碰撞
4)若是树结构，就到树上找，返回value
5)若是链表，则到链表上找，返回value
#### containsKey方法思路：
与get方法类似，但是返回值为布尔值
#### containsValue方法思路：
外层循环遍历node[],内层循环遍历node外挂的树或链表，有一样的value就返回true，否则返回false
### HashSet
内部使用HashMap实现，value位置使用new Object占位

## 树
二叉树：
```
public class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
```
### 二叉树的遍历
根据访问根节点的先后划分为：前序遍历(pre-prder) 中序遍历(in-order) 后序遍历(post-order)
时间复杂度：O(n)
递归和迭代两种方式

## 堆 Heap
可以迅速找到一堆数中的最大或者最小值的数据结构
大顶堆：根节点大于左右子树，左右子树也是大顶堆
find-max：O(1) delete-max：O(logn) insert:O(logn)或O(1)
小顶堆：根节点小于左右子树，左右子树也是小顶堆

常见的队实现有二叉堆、斐波那契堆等

### 二叉堆
二叉堆通过完全二叉树来实现，基于完全二叉树的特殊性质又可映射到一维数组上
设一节点index为i，则左儿子节点的index为2i+1，右儿子节点index为2i+2.父节点index为(i-1)/2

## 图
### dfs模板
```
visited = set()  # 和树中的DFS最大区别

def dfs(node, visited):
  if node in visited: # 避免重复访问一个节点
    return
  
  visited.add(node)
  # process current node here.
  ...

  for next_node in node.children():
    if not next_node in visited:
      dfs(next_node, visited)

```
### bfs模板
```
def BFS(graph, start, end):

  queue = []
  queue.append([start])

  visited = set() # 和树中的BFS的最大区别

  while queue:
    node = queue.pop()
    visited.add(node)

    process(node)
    nodes = generate_related_nodes(node)
    queue.push(nodes)

```