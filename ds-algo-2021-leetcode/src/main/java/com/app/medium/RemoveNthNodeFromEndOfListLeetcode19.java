package com.app.medium;

import com.app.common.LinkedList;
import com.app.common.LinkedList.ListNode;

/**
 * @author t0k02w6 on 16/02/23
 * @project ds-algo-2021-leetcode
 */
public class RemoveNthNodeFromEndOfListLeetcode19 {
  private static ListNode removeNthFromEnd(ListNode head, int n) {
    if(head == null || head.next == null)
      return null;

    int count = 0;
    ListNode fast = head;
    while(fast != null && count < n) {
      fast = fast.next;
      count++;
    }

    ListNode slow = head;
    ListNode prev = head;
    while(fast != null && slow != null) {
      prev = slow;
      fast = fast.next;
      slow = slow.next;
    }

    if(slow == head)
      head = head.next;
    else
      prev.next = slow.next;
    return head;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
//    head.next.next = new ListNode(3);
//    head.next.next.next = new ListNode(4);
//    head.next.next.next.next = new ListNode(5);

    head = removeNthFromEnd(head, 2);

    ListNode temp = head;
    while(temp != null) {
      System.out.println(temp.val);
      temp = temp.next;
    }
  }
}
