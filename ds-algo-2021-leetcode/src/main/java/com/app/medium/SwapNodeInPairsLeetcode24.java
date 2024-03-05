package com.app.medium;

import com.app.common.LinkedList.ListNode;

public class SwapNodeInPairsLeetcode24 {
    private static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode oddPairs = new ListNode(Integer.MAX_VALUE);
        ListNode evenPairs = new ListNode(Integer.MAX_VALUE);

        ListNode oddTemp = oddPairs;
        ListNode evenTemp = evenPairs;

        ListNode temp = head;
        while(temp != null && temp.next != null) {
            ListNode curr = temp;
            temp = temp.next;
            curr.next = null;
            oddTemp.next = curr;
            oddTemp = oddTemp.next;

            curr = temp;
            temp = temp.next;
            curr.next = null;
            evenTemp.next = curr;
            evenTemp = evenTemp.next;
        }

        if(temp != null) {
            oddTemp.next = temp;
        }
        oddPairs = oddPairs.next;
        evenPairs = evenPairs.next;

        oddTemp = oddPairs;
        evenTemp = evenPairs;

        ListNode finalList = new ListNode(Integer.MAX_VALUE);
        temp = finalList;

        while(oddTemp != null && evenTemp != null) {
            ListNode curr1 = evenTemp;
            evenTemp = evenTemp.next;
            curr1.next = null;

            temp.next = curr1;
            temp = temp.next;

            curr1 = oddTemp;
            oddTemp = oddTemp.next;
            curr1.next = null;
            temp.next = curr1;
            temp = temp.next;
        }

        if(oddTemp != null && oddTemp.next == null) {
            temp.next = oddTemp;
        }

        finalList = finalList.next;
        return finalList;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        head = swapPairs(head);
        ListNode temp = head;
        while(temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}
