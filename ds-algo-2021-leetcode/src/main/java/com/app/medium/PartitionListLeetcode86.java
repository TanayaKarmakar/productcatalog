package com.app.medium;

import com.app.common.LinkedList;
import com.app.common.LinkedList.ListNode;

/**
 * @author t0k02w6 on 09/04/23
 * @project ds-algo-2021-leetcode
 */
public class PartitionListLeetcode86 {
  private static ListNode partition(ListNode head, int x) {
    if(head == null || head.next == null)
      return head;
    ListNode smaller = new ListNode(Integer.MAX_VALUE);
    ListNode greater = new ListNode(Integer.MAX_VALUE);

    ListNode smallerTemp = smaller;
    ListNode greaterTemp = greater;

    ListNode temp = head;

    while(temp != null) {
      ListNode curr = temp;
      temp = temp.next;
      curr.next = null;
      if(curr.val < x) {
        smallerTemp.next = curr;
        smallerTemp = smallerTemp.next;
      } else {
        greaterTemp.next = curr;
        greaterTemp = greaterTemp.next;
      }
    }

    smaller = smaller.next;
    greater = greater.next;

    if(smaller == null) {
      smaller = greater;
    } else {
      smallerTemp.next = greater;
    }

    return smaller;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(4);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(2);
    head.next.next.next.next = new ListNode(5);
    head.next.next.next.next.next = new ListNode(2);

    int x = 3;

    head = partition(head, x);

    ListNode temp = head;

    while(temp != null) {
      System.out.print(temp.val + " ");
      temp = temp.next;
    }
    System.out.println();
  }
}
