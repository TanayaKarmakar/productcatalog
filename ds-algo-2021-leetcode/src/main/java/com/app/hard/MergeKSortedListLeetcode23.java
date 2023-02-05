package com.app.hard;

import com.app.common.LinkedList.ListNode;
import java.util.PriorityQueue;

/**
 * @author t0k02w6 on 29/01/23
 * @project ds-algo-2021
 */
public class MergeKSortedListLeetcode23 {
  static class ListItem implements Comparable<ListItem> {
    ListNode curr;
    int aNode;
    int vNode;

    public ListItem(ListNode curr, int aNode, int vNode) {
      this.curr = curr;
      this.aNode = aNode;
      this.vNode = vNode;
    }

    @Override
    public int compareTo(ListItem o) {
      return this.curr.val - o.curr.val;
    }
  }

  private static ListNode mergeKLists(ListNode[] lists) {
    PriorityQueue<ListItem> pQ = new PriorityQueue<>();
    ListNode result = new ListNode(Integer.MAX_VALUE);
    ListNode temp = result;
    for(int i = 0; i < lists.length; i++) {
      if(lists[i] != null)
        pQ.add(new ListItem(lists[i], i, 0));
    }

    while(!pQ.isEmpty()) {
      ListItem listItem = pQ.poll();
      ListNode current = listItem.curr;
      if(current.next != null)
        pQ.add(new ListItem(current.next, listItem.aNode, listItem.vNode + 1));
      temp.next = new ListNode(current.val);
      temp = temp.next;
      current.next = null;
    }

    result = result.next;
    return result;
  }

  public static void main(String[] args) {

  }
}
