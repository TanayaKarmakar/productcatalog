package com.app.medium;

import com.app.common.LinkedList.ListNode;

/**
 * @author t0k02w6 on 01/07/23
 * @project ds-algo-2021-leetcode
 */
public class RemoveDuplicateFromSortedListIILeetcode82 {
  private static ListNode deleteDuplicates(ListNode head) {
    if(head == null || head.next == null)
      return head;
    ListNode curr = head;
    ListNode next = null;

    while(curr != null) {
      next = curr.next;
      while(next != null && next.val == curr.val) {
        next = next.next;
      }

      if(curr.next != next) {
        curr.val = Integer.MAX_VALUE;
        curr.next = next;
      }
      curr = next;
    }

    ListNode result = new ListNode(Integer.MAX_VALUE);
    ListNode temp = result;
    curr = head;

    while(curr != null) {
      if(curr.val != Integer.MAX_VALUE) {
        temp.next = new ListNode(curr.val);
        temp = temp.next;
      }
      curr = curr.next;
    }

    result = result.next;
    return result;

  }

  public static void main(String[] args) {

  }
}
