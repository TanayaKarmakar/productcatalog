package com.app.medium;

import com.app.common.LinkedList.ListNode;

/**
 * @author t0k02w6 on 14/04/22
 * @project ds-algo-2021
 */
public class RemoveDuplicatesFromSortedListIILeetcode82 {
    private static ListNode deleteDuplicates(ListNode head) {
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
        ListNode tmp = result;

        curr = head;
        while(curr != null) {
            if(curr.val != Integer.MAX_VALUE) {
                tmp.next = new ListNode(curr.val);
                tmp = tmp.next;
            }
            curr = curr.next;
        }

        result = result.next;
        tmp = result;

        return tmp;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);

        head = deleteDuplicates(head);
        ListNode tmp = head;

        while(tmp != null) {
            System.out.print(tmp.val + " ");
            tmp = tmp.next;
        }

        System.out.println();
    }
}
