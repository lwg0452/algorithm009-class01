# 第四周学习笔记
## 深度优先搜索DFS
### 递归模板
```
visited = set() 

def dfs(node, visited):
    # terminator
	if node in visited: 
    	return 
		
	visited.add(node)
	
	# process current node here. 
	...
	
	for next_node in node.children(): 
		if next_node not in visited: 
			dfs(next_node, visited)
```		
### 非递归(手动维护一个栈)模板
```
def DFS(self, tree): 
	if tree.root is None: 
		return [] 
	
	visited, stack = [], [tree.root]
	
	while stack: 
		node = stack.pop() 
		visited.add(node)
		process (node) 
		nodes = generate_related_nodes(node) 
		stack.push(nodes) 
	# other processing work 
	...
```

## 广度优先搜索BFS
手动维护一个队列
### 模板
```
def BFS(graph, start, end):
    visited = set()
	queue = [] 
	queue.append([start]) 
	while queue: 
		node = queue.pop() 
		visited.add(node)
		process(node) 
		nodes = generate_related_nodes(node) 
		queue.push(nodes)
	# other processing work 
	...
```

## 贪心算法    
贪心算法是一种在每一步选择中都采取在当前状态下最好或最优（即最有利）的选择，从而希望导致结果是全局最好或最优的算法。 (需要证明问题具有最优子结构性质)     
贪心算法与动态规划的不同在于它对每个子问题的解决方案都做出选择，不能回退。动态规划则会保存以前的运算结果，并根据以前的结果对当前进行选择，有回退功能。     


## 二分查找
二分查找的前提：    
1. 目标函数单调性（单调递增或者递减）    
2. 存在上下界（bounded）     
3. 能够通过索引访问（index accessible)     
### 二分查找模板
```
left, right = 0, len(array) - 1
while left <= right:
    mid = left + (right - left) / 2
    if array[mid] == target:   # find the target!!
        break or return result
    elif array[mid] < target:
        left = mid + 1
    else:
        right = mid - 1
```