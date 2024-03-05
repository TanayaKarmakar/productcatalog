package com.app.medium;

import com.app.common.LinkedList.ListNode;

public class ReorderListLeetcode143 {
    private static void reorderList(ListNode head) {
        if(head == null || head.next == null) {
            return;
        }
        ListNode mid = findMid(head);
        ListNode midNext = mid.next;
        mid.next = null;

        midNext = reverse(midNext);

        ListNode temp1 = head;
        ListNode temp2 = midNext;

        ListNode result = new ListNode(Integer.MAX_VALUE);
        ListNode temp3 = result;

        while(temp1 != null && temp2 != null) {
            ListNode curr1 = temp1;
            ListNode curr2 = temp2;
            temp1 = temp1.next;
            temp2 = temp2.next;
            curr1.next = null;
            curr2.next = null;
            temp3.next = curr1;
            temp3 = temp3.next;
            temp3.next = curr2;
            temp3 = temp3.next;
        }
        if(temp1 != null && temp1.next == null) {
            temp3.next = temp1;
        }
        result = result.next;
        head = result;
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private static ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        reorderList(head);

        ListNode temp = head;
        while(temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}
