package com.app.medium;

import com.app.common.LinkedList.ListNode;

public class RemoveNthNodeFromTheEndOfTheListLeetcode19 {
    private static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || (head.next == null && n > 0))
            return null;
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && n-- > 0) {
            fast = fast.next;
        }

        ListNode slowPrev = head;
        while(fast != null) {
            slowPrev = slow;
            slow = slow.next;
            fast = fast.next;
        }

        if(slow == head) {
            head = head.next;
            slow.next = null;
        } else {
            slowPrev.next = slow.next;
        }
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
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}
