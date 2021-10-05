package com.app.medium;

import com.app.common.LinkedList;
import static com.app.common.LinkedList.ListNode;

/**
 * @author t0k02w6 on 01/08/21
 * @project ds-algo-2021
 */
public class SwapNodeInPairsLeetcode24 {
    private static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        ListNode nextNext = null;

        while(curr != null && curr.next != null) {
            next = curr.next;
            nextNext = next.next;
            next.next = curr;
            curr.next = nextNext;
            if(curr == head)
                head = next;
            if(prev != null)
                prev.next = next;
            prev = curr;
            curr = nextNext;
        }

        return head;
    }

    private static void printList(ListNode p) {
        System.out.println("Printing the list");
        ListNode tmp = p;
        while(tmp != null) {
            System.out.print(tmp.val + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        ListNode ans = swapPairs(list.head);
        printList(ans);

        list = new LinkedList();
        list.head = new ListNode(1);
        ans = swapPairs(list.head);
        printList(ans);

        list = new LinkedList();
        list.head = new ListNode(1);
        list.head.next = new ListNode(2);
        //list.head.next.next = new ListNode(3);
        ans = swapPairs(list.head);
        printList(ans);

        list = new LinkedList();
        list.head = new ListNode(1);
        list.head.next = new ListNode(2);
        list.head.next.next = new ListNode(3);
        ans = swapPairs(list.head);
        printList(ans);


        list = new LinkedList();
        list.head = new ListNode(1);
        list.head.next = new ListNode(2);
        list.head.next.next = new ListNode(3);
        list.head.next.next.next = new ListNode(4);
        ans = swapPairs(list.head);
        printList(ans);

    }
}
