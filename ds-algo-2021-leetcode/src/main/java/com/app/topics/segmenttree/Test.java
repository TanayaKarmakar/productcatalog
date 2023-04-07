package com.app.topics.segmenttree;

import com.app.common.LinkedList;

/**
 * @author t0k02w6 on 08/02/23
 * @project ds-algo-2021
 */
public class Test {
  static class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
      this.val = val;
    }
  }



  public static ListNode detectAndRemoveLoop(ListNode head) {
    if(head == null || head.next == null)
      return head;
    ListNode slow = head;
    ListNode fast = head;


    do {
      slow = slow.next;
      fast = fast.next.next;
      System.out.println("detecting loop at " + slow.val);
    } while(fast != null && slow != fast);

    if(slow != fast)
      return head;

    slow = head;
    while(slow != fast) {
      slow = slow.next;
      fast = fast.next;
    }

    while(fast.next != slow) {
      fast = fast.next;
    }

    fast.next = null;

    return head;

  }


  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    head.next.next.next.next.next = new ListNode(6);
    head.next.next.next.next.next.next = head.next.next;

    head = detectAndRemoveLoop(head);

    ListNode temp = head;
    while(temp != null) {
      System.out.println(temp.val);
      temp = temp.next;
    }
  }
}
