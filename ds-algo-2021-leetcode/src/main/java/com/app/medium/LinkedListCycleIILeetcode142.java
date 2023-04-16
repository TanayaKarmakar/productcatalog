package com.app.medium;

import com.app.common.LinkedList.ListNode;

/**
 * @author t0k02w6 on 16/04/23
 * @project ds-algo-2021-leetcode
 */
public class LinkedListCycleIILeetcode142 {
  private static ListNode detectCycle(ListNode head) {
    if(head == null || head.next == null)
      return null;
    ListNode slow = head;
    ListNode fast = head;

    while(fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if(slow == fast)
        break;
    }

    if(slow != fast)
      return null;

    slow = head;
    while(slow != fast) {
      slow = slow.next;
      fast = fast.next;
    }
    return slow;
  }

  public static void main(String[] args) {

  }
}
