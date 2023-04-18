package com.app.medium;

import com.app.common.LinkedList.ListNode;

/**
 * @author t0k02w6 on 17/04/23
 * @project ds-algo-2021-leetcode
 */
public class SwapNodesInPairsLeetcode24 {
  private static ListNode swapPairs(ListNode head) {
    if(head == null || head.next == null)
      return head;
    ListNode curr = head;
    ListNode next = null;
    ListNode nextNext = null;
    ListNode prev = null;

    while(curr != null && curr.next != null) {
      next = curr.next;
      nextNext = next.next;

      next.next = curr;
      curr.next = nextNext;

      if(curr == head) {
        head = next;
      }

      if(prev != null)
        prev.next = next;
      prev = curr;
      curr = nextNext;
    }

    return head;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);

    head = swapPairs(head);

    ListNode temp = head;
    while(temp != null) {
      System.out.println(temp.val);
      temp = temp.next;
    }
  }
}
