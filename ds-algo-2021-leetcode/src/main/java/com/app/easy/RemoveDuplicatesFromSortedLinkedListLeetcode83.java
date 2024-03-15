package com.app.easy;

import com.app.common.LinkedList.ListNode;

public class RemoveDuplicatesFromSortedLinkedListLeetcode83 {
    private static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode p = head;
        ListNode q = null;
        while(p != null) {
            q = p.next;
            while(q != null && p.val == q.val) {
                q = q.next;
            }
            p.next = q;
            p = q;
        }
        return head;
    }

    public static void main(String[] args) {

    }
}
