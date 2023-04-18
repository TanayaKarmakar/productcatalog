package com.app.medium;

import com.app.common.LinkedList.ListNode;

/**
 * @author t0k02w6 on 17/04/23
 * @project ds-algo-2021-leetcode
 */
public class RemoveNthNodeFromEndOfLinkedList19 {
  private static ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode slow = head;
    ListNode fast = head;

    int count = 0;
    while(fast != null && count < n) {
      fast = fast.next;
      count++;
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
