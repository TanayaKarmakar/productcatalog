package com.app.easy;

import com.app.common.LinkedList.ListNode;

public class LinkedListCycleLeetcode141 {
    private static boolean hasCycle(ListNode head) {
        if(head == null || head.next == null)
            return false;
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                break;
        }

        if(slow != fast)
            return false;
        return true;
    }

    public static void main(String[] args) {

    }
}
