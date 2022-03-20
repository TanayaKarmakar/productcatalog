package com.app.easy;

import com.app.common.LinkedList;
import com.app.common.LinkedList.ListNode;

/**
 * @author t0k02w6 on 20/03/22
 * @project ds-algo-2021
 */
public class RemoveDuplicatesFromSortedLinkedListLeetcode83 {
    private static ListNode deleteDuplicates(ListNode head) {
        ListNode tmp = head;
        while(tmp != null) {
            ListNode tmpNext = tmp.next;
            while(tmpNext != null && tmp.val == tmpNext.val) {
                tmpNext = tmpNext.next;
            }
            tmp.next = tmpNext;
            tmp = tmpNext;
        }
        return head;
    }

    public static void main(String[] args) {

    }
}
