package com.app.medium;

import com.app.common.LinkedList.ListNode;

/**
 * @author t0k02w6 on 08/06/23
 * @project ds-algo-2021-leetcode
 */
public class RemoveNthNodeFromTheListLeetcode19 {
  private static ListNode removeNthFromEnd(ListNode head, int n) {
    if(head == null || (head.next == null && n == 1))
      return null;
    if(head.next == null && n > 1)
      return head;
    ListNode slow = head;
    ListNode fast = head;

    while(fast != null && n-- > 0) {
      fast = fast.next;
      n--;
    }

    ListNode slowPrev = head;
    while(fast != null) {
      slowPrev = slow;
      slow = slow.next;
      fast = fast.next;
    }

    if(slow == head) {
      head = head.next;
      slow.next = null;
    } else {
      slowPrev.next = slow.next;
    }

    return head;

  }

  public static void main(String[] args) {

  }
}
