package com.app.medium;

import com.app.common.LinkedList.ListNode;

/**
 * @author t0k02w6 on 01/10/22
 * @project ds-algo-2021-leetcode
 */
public class ReorderListLeetcode143 {
  private static void reorderList(ListNode head) {
    if(head == null)
      return;
    ListNode mid = findMid(head);
    ListNode midNext = mid.next;
    mid.next = null;

    midNext = reverse(midNext);

    ListNode tmp1 = head;
    ListNode tmp2 = midNext;

    ListNode result = new ListNode(Integer.MAX_VALUE);
    ListNode tmp3 = result;

    while(tmp1 != null && tmp2 != null) {
      ListNode curr = tmp1;
      tmp1 = tmp1.next;
      curr.next = null;

      tmp3.next = curr;
      tmp3 = tmp3.next;

      curr = tmp2;
      tmp2 = tmp2.next;
      curr.next = null;

      tmp3.next = curr;
      tmp3 = tmp3.next;
    }

    if(tmp1 != null) {
      tmp3.next = new ListNode(tmp1.val);
      tmp3 = tmp3.next;
      tmp3.next = null;
    }

    result = result.next;
    head = result;
  }

  private static ListNode reverse(ListNode node) {
    ListNode prev = null;
    ListNode curr = node;
    ListNode next = null;

    while(curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }

    return prev;
  }

  private static ListNode findMid(ListNode head) {
    if(head == null)
      return null;
    ListNode slow = head;
    ListNode fast = head;

    while(fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);

    reorderList(head);

    ListNode tmp = head;

    while(tmp != null) {
      System.out.print(tmp.val + " ");
      tmp = tmp.next;
    }
    System.out.println();
  }
}
