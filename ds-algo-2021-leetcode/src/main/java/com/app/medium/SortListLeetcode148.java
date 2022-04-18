package com.app.medium;

import com.app.common.LinkedList;
import com.app.common.LinkedList.ListNode;

/**
 * @author t0k02w6 on 16/04/22
 * @project ds-algo-2021
 */
public class SortListLeetcode148 {
    private static ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private static ListNode merge(ListNode left, ListNode right) {
        if(left == null)
            return right;
        if(right == null)
            return left;
        ListNode result;

        if(left.val < right.val) {
            result = left;
            result.next = merge(left.next, right);
        } else {
            result = right;
            result.next = merge(left, right.next);
        }
        return result;
    }

    private static ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode mid = findMid(head);
        ListNode midNext = mid.next;
        mid.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(midNext);
        return merge(left, right);
    }



    public static void main(String[] args) {

    }
}
