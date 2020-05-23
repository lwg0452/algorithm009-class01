# 第一周学习笔记
## 数组 Array
在内存中开辟出的一块连续空间
操作|复杂度
|--|--|
查找|O(1)
插入|O(n)
删除|O(n) 
prepend|O(1)
append|O(1)

## 链表 Linked List
不要求连续存储空间，节点间通过指针连接
单链表 双向链表 循环链表
操作|复杂度
|--|--|
查找|O(n)
插入|O(1)
删除|O(1) 
prepend|O(1)
append|O(1)

## 跳表 Skip List
使用条件：链表元素有序
思想：一维数据结构加速 ==> 升维
实现方式：在有序链表上加多级索引
操作|复杂度
|--|--|
查找|O(logn)
插入|O(logn)
删除|O(logn) 

## 栈 Stack
First in last out
推荐使用Deque接口创建stack
```
Deque<Integer> stack = new ArrayDeque<Integer>();
```
push() pop() peek()
## 队列 Queue
First in first out
```
Queue<String> queue = new LinkedList<String>();
```
offer() poll() peek()

## 双端队列
## 作业：使用新的API改写deque代码
```
Deque<String> deque = new LinkedList<>();

    deque.offerLast("a");
    deque.offerLast("b");
    deque.offerLast("c");
    System.out.println(deque);

    String str = deque.peekFirst();
    System.out.println(str);
    System.out.println(deque);

    while (deque.size() > 0) {
      System.out.println(deque.pollFirst());
    }
    System.out.println(deque);
```

## 优先队列 Priority Queue
多种实现方式：heap, BST, treap...
操作|复杂度
|--|--|
取出|O(logn)
插入|O(1)