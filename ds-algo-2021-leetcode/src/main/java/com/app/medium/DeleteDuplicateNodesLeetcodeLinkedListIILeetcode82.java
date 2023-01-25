package com.app.medium;

import com.app.common.LinkedList;
import com.app.common.LinkedList.ListNode;

/**
 * @author t0k02w6 on 21/11/22
 * @project ds-algo-2021
 */
public class DeleteDuplicateNodesLeetcodeLinkedListIILeetcode82 {
  private static ListNode deleteDuplicates(ListNode head) {
    if(head == null || head.next == null)
      return head;

    ListNode curr = head;
    ListNode next = null;

    while(curr != null) {
      next = curr.next;

      while(next != null && curr.val == next.val) {
        next = next.next;
      }

      if(curr.next != next) {
        curr.val = Integer.MAX_VALUE;
        curr.next = next;
      }

      curr = next;
    }

    ListNode result = new ListNode(Integer.MAX_VALUE);
    ListNode temp = result;

    ListNode temp1 = head;
    while(temp1 != null) {
      if(temp1.val != Integer.MAX_VALUE) {
        ListNode currNode = new ListNode(temp1.val);
        temp.next = currNode;
        temp = temp.next;
      }
      temp1 = temp1.next;
    }

    result = result.next;

    return result;
  }

  public static void main(String[] args) {

  }
}
