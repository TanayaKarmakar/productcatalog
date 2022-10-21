package com.app.medium;

import com.app.common.LinkedList;
import com.app.common.LinkedList.ListNode;

/**
 * @author t0k02w6 on 02/10/22
 * @project ds-algo-2021-leetcode
 */
public class RemoveNthNodeFromEndOfListLeetcode19 {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    if(head == null)
      return null;
    if(head.next == null) {
      if(n == 1)
        return null;
      return head;
    }
    ListNode fast = head;
    int count = 0;
    while(fast != null && count < n) {
      fast = fast.next;
      count++;
    }

    ListNode slow = head;
    ListNode slowPrev = head;
    while(fast != null) {
      slowPrev = slow;
      slow = slow.next;
      fast = fast.next;
    }
    if(slow == head) {
      head = head.next;
    } else {
      slowPrev.next = slow.next;
    }
    return head;
  }

  public static void main(String[] args) {

  }
}
