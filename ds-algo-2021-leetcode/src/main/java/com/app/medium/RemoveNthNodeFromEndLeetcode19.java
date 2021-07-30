package com.app.medium;

import com.app.common.LinkedList;

import java.util.List;

import static com.app.common.LinkedList.ListNode;

/**
 * @author t0k02w6 on 29/07/21
 * @project ds-algo-2021
 */
public class RemoveNthNodeFromEndLeetcode19 {
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
        LinkedList list = new LinkedList();
        list.head = new ListNode(1);
        list.head.next = new ListNode(2);
//        list.head.next.next = new ListNode(3);
//        list.head.next.next.next = new ListNode(4);
//        list.head.next.next.next.next = new ListNode(5);

        int n = 1;
        ListNode head = removeNthFromEnd(list.head, n);

        ListNode tmp = head;
        while(tmp != null) {
            System.out.print(tmp.val + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }
}
