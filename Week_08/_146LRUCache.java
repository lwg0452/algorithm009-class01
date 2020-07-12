import java.util.HashMap;
import java.util.Map;

class LRUCache {

  Map<Integer, DLinkedNode> cache;
  int capacity;
  int size;
  DLinkedNode head, tail;

  public LRUCache(int capacity) {
    cache = new HashMap<>();
    this.capacity = capacity;
    size = 0;
    head = new DLinkedNode();
    tail = new DLinkedNode();
    head.next = tail;
    tail.pre = head;
  }

  public int get(int key) {
    DLinkedNode node = cache.get(key);
    if (node == null) {
      return -1;
    }
    removeNode(node);
    addNode(node);
    return node.value;
  }

  public void put(int key, int value) {
    DLinkedNode node = cache.get(key);
    if (node == null) {
      node = new DLinkedNode();
      node.key = key;
      node.value = value;
      addNode(node);
      size++;
      if (size > capacity) {
        cache.remove(tail.pre.key);
        removeNode(tail.pre);
        size--;
      }
    } else {
      removeNode(node);
      node.value = value;
      addNode(node);
    }
    cache.put(key, node);
  }

  class DLinkedNode {

    int key;
    int value;
    DLinkedNode pre;
    DLinkedNode next;
  }


  private void addNode(DLinkedNode node) {
    node.pre = head;
    node.next = head.next;
    head.next.pre = node;
    head.next = node;
  }

  private void removeNode(DLinkedNode node) {
    DLinkedNode pre = node.pre, next = node.next;
    pre.next = next;
    next.pre = pre;
  }
}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj = new
 * LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */