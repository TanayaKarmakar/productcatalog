package com.app.medium;

import com.app.common.LinkedList.ListNode;

/**
 * @author t0k02w6 on 12/04/22
 * @project ds-algo-2021
 */
public class RemoveNthNodeFromTheEndOfListLeetcode19 {
    private static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null)
            return head;
        if(head.next == null) {
            if(n == 1)
                return null;
            return head;
        }

        ListNode fast = head;
        int count = 0;
        while(fast != null && count < n) {
            fast = fast.next;
            count++;
        }

        ListNode slow = head;
        ListNode slowPrev = head;
        while(fast != null) {
            slowPrev = slow;
            slow = slow.next;
            fast = fast.next;
        }

        if(slow == head)
            head = head.next;
        else
            slowPrev.next = slow.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int n = 2;
        head = removeNthFromEnd(head, n);

        ListNode temp = head;
        while(temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }
}
