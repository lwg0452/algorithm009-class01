/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
 * x) { val = x; } }
 */
class Solution {

  //Recursion method Time:O(n) Space:O(n)
  public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode p1 = head;
    ListNode p2 = head.next;
    ListNode p3 = head.next.next;
    p2.next = p1;
    p1.next = swapPairs(p3);
    return p2;
  }
}
