package com.app.hard;

import com.app.common.LinkedList.ListNode;

public class ReverseNodeInKGroupLeetcode25 {
    private static ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || length(head) < k)
            return head;
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        int count = 0;

        while(curr != null && count < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        if(next != null) {
            ListNode restHead = reverseKGroup(next, k);
            head.next = restHead;
        }
        return prev;
    }

    private static int length(ListNode head) {
        int len = 0;
        ListNode temp = head;
        while(temp != null) {
            temp = temp.next;
            len++;
        }
        return len;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 2;
        head = reverseKGroup(head, k);

        ListNode temp = head;
        while(temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}
