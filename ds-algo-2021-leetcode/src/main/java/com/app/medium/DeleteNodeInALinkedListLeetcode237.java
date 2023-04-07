package com.app.medium;

import com.app.common.LinkedList.ListNode;

/**
 * @author t0k02w6 on 05/02/23
 * @project ds-algo-2021
 */
public class DeleteNodeInALinkedListLeetcode237 {
  private static void deleteNode(ListNode node) {
    ListNode next = node.next;
    node.val = next.val;
    node.next = next.next;
  }

  public static void main(String[] args) {

  }
}
