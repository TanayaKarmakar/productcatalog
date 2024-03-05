package com.app.medium;

import com.app.common.LinkedList.ListNode;

public class ReverseLinkedListIILeetcode92 {
    private static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode leftP = head;
        ListNode leftPrev = null;

        while(leftP.val != left) {
            leftPrev = leftP;
            leftP = leftP.next;
        }

        ListNode rightP = leftP;
        while(rightP.val != right) {
            rightP = rightP.next;
        }

        if(leftPrev != null) {
            leftPrev.next = null;
        }

        ListNode rightNext = null;
        if(rightP.next != null) {
            rightNext = rightP.next;
            rightP.next = null;
        }

        leftP = reverse(leftP);

        if(leftPrev == null) {
            head = leftP;
        } else {
            leftPrev.next = leftP;
        }

        if(rightNext != null) {
            ListNode temp = head;
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = rightNext;
        }

        return head;

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

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int left = 2;
        int right = 4;
        head = reverseBetween(head, left, right);

        ListNode temp = head;
        while(temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }

        System.out.println();
    }
}
