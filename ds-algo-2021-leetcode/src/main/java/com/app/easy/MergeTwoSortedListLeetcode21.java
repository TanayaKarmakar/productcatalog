package com.app.easy;

import com.app.common.LinkedList.ListNode;

/**
 * @author t0k02w6 on 28/01/23
 * @project ds-algo-2021
 */
public class MergeTwoSortedListLeetcode21 {
  private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    if(list1 == null)
      return list2;
    if(list2 == null)
      return list1;
    ListNode result = new ListNode(Integer.MAX_VALUE);
    ListNode temp1 = list1;
    ListNode temp2 = list2;

    ListNode temp = result;
    while(temp1 != null && temp2 != null) {
      ListNode curr = null;
      if(temp1.val < temp2.val) {
        curr = temp1;
        temp1 = temp1.next;
        curr.next = null;
      } else {
        curr = temp2;
        temp2 = temp2.next;
        curr.next = null;
      }
      temp.next = curr;
      temp = temp.next;
    }

    if(temp1 != null)
      temp.next = temp1;
    if(temp2 != null)
      temp.next = temp2;
    result = result.next;
    return result;
  }

  public static void main(String[] args) {

  }
}
