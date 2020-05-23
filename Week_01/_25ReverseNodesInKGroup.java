/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {}
 * ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
 * this.next = next; } }
 */
class Solution {

  public ListNode reverseKGroup(ListNode head, int k) {
    ListNode dummy = new ListNode(0);  //工具人头节点
    dummy.next = head;
    ListNode p = dummy;
    while (p != null) {
      p = reverse(p, k);
    }
    return dummy.next;
  }

  //反转p后面的k个节点，连在p后(p的位置不动)，返回值为反转后长度为k的子链的尾节点
  private ListNode reverse(ListNode p, int k) {
    ListNode left = p.next, right = p;
    //找到k个节点的最后一个，用right标记；不足k个节点直接返回null
    for (int i = 0; i < k; i++) {
      right = right.next;
      if (right == null) {
        return null;
      }
    }
    //result返回反转后长度为k的子链的尾节点
    ListNode res = left;
    //反转k
    p.next = right;
    ListNode prev = right.next;
    ListNode next = null;
    while (left != res.next) {
      next = left.next;
      left.next = prev;
      prev = left;
      left = next;
    }
    return res;
  }
}