package com.app.medium;

import com.app.common.LinkedList;
import com.app.common.LinkedList.ListNode;

/**
 * @author t0k02w6 on 16/04/22
 * @project ds-algo-2021
 */
public class ReverseLinkedListIILeetcode92 {
    private static ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        dummy.next = head;

        ListNode sublistHead = dummy;
        int k = 1;
        while(k < left) {
            sublistHead = sublistHead.next;
            k++;
        }

        ListNode sublistIter = sublistHead.next;
        while(left < right) {
            ListNode tmp = sublistIter.next;
            sublistIter.next = tmp.next;
            tmp.next = sublistHead.next;
            sublistHead.next = tmp;
            left++;
        }

        dummy = dummy.next;
        return dummy;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int m = 2;
        int n = 4;

        head = reverseBetween(head, m, n);

        ListNode tmp = head;
        while(tmp != null) {
            System.out.print(tmp.val + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }
}
