package com.app.medium;

import com.app.common.LinkedList.ListNode;


/**
 * @author t0k02w6 on 14/04/22
 * @project ds-algo-2021
 */
public class RotateListLeetcode61 {
    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private static int length(ListNode head) {
        ListNode tmp = head;
        int n = 0;
        while(tmp != null) {
            n++;
            tmp = tmp.next;
        }
        return n;
    }

    private static ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null)
            return head;
        int n = length(head);
        if(k >= n) {
            k = k % n;
        }
        if(k == 0)
            return head;
        head = reverse(head);

        ListNode tmp = head;
        ListNode prev = null;
        while(tmp.next != null && k > 0) {
            prev = tmp;
            tmp = tmp.next;
            k--;
        }

        ListNode tmp2 = prev.next;
        prev.next = null;
        tmp = head;

        tmp = reverse(tmp);
        tmp2 = reverse(tmp2);

        ListNode tmp1 = tmp;
        while(tmp1.next != null) {
            tmp1 = tmp1.next;
        }
        tmp1.next = tmp2;
        return tmp;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 2;
        head = rotateRight(head, k);

        ListNode tmp = head;
        while(tmp != null) {
            System.out.print(tmp.val + " ");
            tmp = tmp.next;
        }

        System.out.println();
    }
}
