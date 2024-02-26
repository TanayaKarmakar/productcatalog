package com.app.hard;

import com.app.common.LinkedList.ListNode;

import java.util.PriorityQueue;


public class MergeKSortedListLeetcode23 {
    static class Item implements Comparable<Item> {
        ListNode node;
        int aNode;
        int vNode;

        public Item(ListNode node, int aNode, int vNode) {
            this.node = node;
            this.aNode = aNode;
            this.vNode = vNode;
        }

        @Override
        public int compareTo(Item o) {
            return this.node.val - o.node.val;
        }
    }

    private static ListNode mergeKLists(ListNode[] lists) {
        ListNode result = new ListNode(Integer.MAX_VALUE);
        ListNode temp = result;

        PriorityQueue<Item> pQ = new PriorityQueue<>();
        for(int i = 0; i < lists.length; i++) {
            if(lists[i] != null)
                pQ.add(new Item(lists[i], i, 0));
        }

        while(!pQ.isEmpty()) {
            Item item = pQ.poll();

            ListNode curr = item.node;
            item.node = item.node.next;

            curr.next = null;
            temp.next = curr;
            temp = temp.next;

            if(item.node != null) {
                pQ.add(new Item(item.node, item.aNode, item.vNode + 1));
            }
        }

        result = result.next;
        return result;
    }

    public static void main(String[] args) {

    }
}
