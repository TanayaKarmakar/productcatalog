package com.app.easy;

import com.app.common.LinkedList;
import com.app.common.LinkedList.ListNode;

/**
 * @author t0k02w6 on 20/03/22
 * @project ds-algo-2021
 */
public class DeleteANodeInLinkedListLeetcode237 {
    private static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {

    }
}
