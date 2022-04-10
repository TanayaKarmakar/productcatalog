package com.app.medium;

import com.app.common.LinkedList;
import com.app.common.LinkedList.ListNode;


/**
 * @author t0k02w6 on 10/04/22
 * @project ds-algo-2021
 */
public class ReorderListLeetcode143 {

    private static void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode part1 = head;
        ListNode part2 = slow.next;

        slow.next = null;

        ListNode prev = null;
        ListNode curr = part2;
        ListNode next = null;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }

        part2 = prev;

        ListNode result = new ListNode(Integer.MAX_VALUE);
        ListNode temp = result;

        while (part1 != null && part2 != null) {
            temp.next = new ListNode(part1.val);
            temp = temp.next;
            temp.next = new ListNode(part2.val);
            temp = temp.next;
            part1 = part1.next;
            part2 = part2.next;
        }

        if(part1 != null)
            temp.next = part1;
        result = result.next;
        head = result;

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
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }
}
