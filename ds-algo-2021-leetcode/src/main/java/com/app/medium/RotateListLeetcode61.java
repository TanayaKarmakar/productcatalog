package com.app.medium;

import com.app.common.LinkedList.ListNode;

/**
 * @author t0k02w6 on 28/06/23
 * @project ds-algo-2021-leetcode
 */
public class RotateListLeetcode61 {
  private static ListNode rotateRight(ListNode head, int k) {
    if(head == null)
      return null;
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
    head = reverse(head);
    int count = 1;
    temp = head;
    while(temp != null && count < k) {
      temp = temp.next;
      count++;
    }

    ListNode tmpNext = temp.next;
    temp.next = null;
    head = reverse(head);
    tmpNext = reverse(tmpNext);

    temp = head;
    while(temp.next != null) {
      temp = temp.next;
    }

    temp.next = tmpNext;
    return head;
  }


  private static ListNode reverse(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    ListNode next;

    while(curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    return prev;
  }

//  private static int len(ListNode head) {
//    ListNode temp = head;
//    int count = 0;
//    while(temp != null) {
//      temp = temp.next;
//      count++;
//    }
//    return count;
//  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);

    head = rotateRight(head, 2);

    ListNode temp = head;
    while(temp != null) {
      System.out.print(temp.val + " ");
      temp = temp.next;
    }
    System.out.println();
  }
}
