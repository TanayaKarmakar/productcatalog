package com.app.medium;

import com.app.common.LinkedList.ListNode;

/**
 * @author t0k02w6 on 08/06/23
 * @project ds-algo-2021-leetcode
 */
public class LinkedListCycleIILeetcode142 {
  private static ListNode detectCycle(ListNode head) {
    if(head == null || head.next == null)
      return null;
    ListNode slow = head;
    ListNode fast = head;

    do {
      slow = slow.next;
      fast = fast.next.next;
    } while(fast != null && fast.next != null && slow != fast);

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
