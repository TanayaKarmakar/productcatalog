package com.app.medium;

import com.app.common.LinkedList;
import com.app.common.LinkedList.ListNode;

/**
 * @author t0k02w6 on 17/10/22
 * @project ds-algo-2021-leetcode
 */
public class RotateListLeetcode61 {
  private static ListNode rotateRight(ListNode head, int k) {
    int len = 0;
    ListNode temp = head;
    while(temp != null) {
      len++;
      temp = temp.next;
    }

    if(k > len) {
      k = k % len;
    }
    if(k == 0)
      return head;
    head = reverseList(head);
    int count = 1;
    temp = head;
    while(temp != null && count <= k) {
      temp = temp.next;
      count++;
    }

    ListNode tmpNext = temp.next;
    temp.next = null;
    head = reverseList(head);
    tmpNext = reverseList(tmpNext);

    temp = head;
    while(temp.next != null) {
      temp = temp.next;
    }

    temp.next = tmpNext;
    return head;

  }

  private static ListNode reverseList(ListNode head) {
    if(head == null)
      return null;
    ListNode prev = null;
    ListNode curr = head;
    ListNode next = null;

    while(curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    return prev;
  }

  public static void main(String[] args) {

  }
}
