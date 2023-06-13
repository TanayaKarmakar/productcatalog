package com.app.medium;

import com.app.common.LinkedList.ListNode;

/**
 * @author t0k02w6 on 01/06/23
 * @project ds-algo-2021-leetcode
 */
public class OddEvenLinkedListLeetcode328 {
  private static ListNode oddEvenList(ListNode head) {
    if(head == null || head.next == null)
      return head;
    ListNode oddList = new ListNode(Integer.MAX_VALUE);
    ListNode evenList = new ListNode(Integer.MAX_VALUE);

    ListNode oddPtr = oddList;
    ListNode evenPtr = evenList;

    ListNode listPtr = head;
    int indx = 1;
    while(listPtr != null) {
      ListNode currentNode = listPtr;
      listPtr = listPtr.next;
      if(indx % 2 == 0) {
        evenPtr.next = currentNode;
        evenPtr = evenPtr.next;
        evenPtr.next = null;
      } else {
        oddPtr.next = currentNode;
        oddPtr = oddPtr.next;
        oddPtr.next = null;
      }
      indx++;
    }

    oddList = oddList.next;
    evenList = evenList.next;
    oddPtr.next = evenList;

    return oddList;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);

    head = oddEvenList(head);
    ListNode temp = head;
    while(temp != null) {
      System.out.println(temp.val);
      temp = temp.next;
    }
  }
}
