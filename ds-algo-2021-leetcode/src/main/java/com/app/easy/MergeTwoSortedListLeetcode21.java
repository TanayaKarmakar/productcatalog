package com.app.easy;

import com.app.common.LinkedList;
import static com.app.common.LinkedList.ListNode;

/**
 * @author t0k02w6 on 25/07/21
 * @project ds-algo-2021
 */
public class MergeTwoSortedListLeetcode21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        ListNode result = new ListNode(Integer.MAX_VALUE);
        ListNode tmp = result;

        ListNode tmp1 = l1 ;
        ListNode tmp2 = l2;

        while(tmp1 != null && tmp2 != null) {
            ListNode curr = null;
            if(tmp1.val < tmp2.val) {
                curr = tmp1;
                tmp1 = tmp1.next;
            } else {
                curr = tmp2;
                tmp2 = tmp2.next;
            }
            curr.next = null;
            tmp.next = curr;
            tmp = tmp.next;
        }

        if(tmp1 != null)
            tmp.next = tmp1;
        if(tmp2 != null)
            tmp.next = tmp2;
        result = result.next;
        return result;
    }

    public static void main(String[] args) {

    }
}
