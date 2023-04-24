package com.app.medium;

import com.app.common.LinkedList.ListNode;

/**
 * @author t0k02w6 on 22/04/23
 * @project ds-algo-2021-leetcode
 */
public class SortListLeetcode148 {
  private static ListNode sortList(ListNode head) {
    if(head == null || head.next == null)
      return head;
    ListNode mid = findMid(head);
    ListNode midNext = mid.next;
    mid.next = null;
    ListNode part1 = sortList(head);
    ListNode part2 = sortList(midNext);
    return merge(part1, part2);
  }

  private static ListNode merge(ListNode part1, ListNode part2) {
    if(part1 == null)
      return part2;
    if(part2 == null)
      return part1;

    ListNode result;
    if(part1.val < part2.val) {
      result = part1;
      result.next = merge(part1.next, part2);
    } else {
      result = part2;
      result.next = merge(part1, part2.next);
    }
    return result;
  }

  private static ListNode findMid(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while(fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(4);
    head.next = new ListNode(2);
    head.next.next = new ListNode(1);
    head.next.next.next = new ListNode(3);

    head = sortList(head);

    ListNode temp = head;
    while(temp != null) {
      System.out.println(temp.val);
      temp = temp.next;
    }
  }
}
