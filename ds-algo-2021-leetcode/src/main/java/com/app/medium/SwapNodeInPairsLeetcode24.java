package com.app.medium;

import com.app.common.LinkedList;
import com.app.common.LinkedList.ListNode;

/**
 * @author t0k02w6 on 13/04/22
 * @project ds-algo-2021
 */
public class SwapNodeInPairsLeetcode24 {
    private static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode tmp = head;
        ListNode tmp1 = tmp.next;


        ListNode list1 = new ListNode(Integer.MAX_VALUE);
        ListNode list2 = new ListNode(Integer.MAX_VALUE);

        ListNode t1 = list1;
        ListNode t2 = list2;
        while(tmp != null && tmp1 != null) {
            ListNode node1 = new ListNode(tmp.val);
            ListNode node2 = new ListNode(tmp1.val);

            t1.next = node1;
            t1 = t1.next;

            t2.next = node2;
            t2 = t2.next;

            tmp = tmp1.next;
            if(tmp != null)
                tmp1 = tmp.next;
            else
                tmp1 = null;
        }

        if(tmp1 != null) {
            t2.next = new ListNode(tmp1.val);
        }

        if(tmp != null) {
            t1.next = new ListNode(tmp.val);
        }

        list1 = list1.next;
        list2 = list2.next;

        t1 = list1;
        t2 = list2;

        ListNode finalList = new ListNode(Integer.MAX_VALUE);
        tmp = finalList;

        while(t1 != null && t2 != null) {
            tmp.next = new ListNode(t2.val);
            tmp = tmp.next;
            tmp.next = new ListNode(t1.val);
            tmp = tmp.next;

            t1 = t1.next;
            t2 = t2.next;
        }

        if(t1 != null) {
            tmp.next = new ListNode(t1.val);
        }

        finalList = finalList.next;
        return finalList;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        head = swapPairs(head);
        ListNode tmp = head;

        while(tmp != null) {
            System.out.print(tmp.val + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }
}
