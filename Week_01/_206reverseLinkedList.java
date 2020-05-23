/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
 * x) { val = x; } }
 */
class Solution {

  public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode prev = null;
    ListNode p = head;
    ListNode next;
    while (p != null) {
      next = p.next;
      p.next = prev;
      prev = p;
      p = next;
    }
    return prev;
  }
}