package com.app.easy;

import com.app.common.LinkedList;
import com.app.common.LinkedList.ListNode;

/**
 * @author t0k02w6 on 21/03/22
 * @project ds-algo-2021
 */
public class RemoveLinkedListElementsLeetcode203 {
    private static ListNode removeElements(ListNode head, int val) {
        if(head == null)
            return head;
        ListNode tmp = head;
        ListNode prev = null;
        while(tmp != null) {
            if(head.val == val) {
                head = head.next;
                tmp = head;
            } else {
                if(prev != null && prev.next.val == val) {
                    prev.next = tmp.next;
                } else {
                    prev = tmp;
                }
                tmp = tmp.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {

    }
}
