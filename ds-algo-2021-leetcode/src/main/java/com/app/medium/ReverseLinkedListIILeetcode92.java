package com.app.medium;

import com.app.common.LinkedList.ListNode;

/**
 * @author t0k02w6 on 26/04/23
 * @project ds-algo-2021-leetcode
 */
public class ReverseLinkedListIILeetcode92 {
  private static ListNode reverseBetween(ListNode head, int left, int right) {
    ListNode part1 = new ListNode(Integer.MAX_VALUE);
    ListNode part2 = null;
    ListNode part3 = null;

    ListNode temp = head;
    ListNode prev = null;
    int count = 1;
    while(temp != null && count < left) {
      prev = temp;
      temp = temp.next;
      count++;
    }

    if(prev != null) {
      part1 = head;
      prev.next = null;
    }

    ListNode temp2 = temp;
    count = left;
    prev = temp;
    while(temp2 != null && count < right) {
      prev = temp2;
      temp2 = temp2.next;
      count++;
    }

    return null;



  }

  public static void main(String[] args) {

  }
}
