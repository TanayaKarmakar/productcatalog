package com.app.easy;

import com.app.common.LinkedList;
import com.app.common.LinkedList.ListNode;

/**
 * @author t0k02w6 on 17/03/22
 * @project ds-algo-2021
 */
public class PalindromeLinkedListLeetcode234 {
    private static boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;
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

        ListNode tmp1 = part1;
        ListNode tmp2 = part2;

        while(tmp1 != null && tmp2 != null) {
            if(tmp1.val != tmp2.val)
                return false;
            tmp1 = tmp1.next;
            tmp2 = tmp2.next;
        }
        return (tmp1 == null || tmp1.next == null);
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(1);


        boolean ans = isPalindrome(node);

        System.out.println(ans);
    }
}
