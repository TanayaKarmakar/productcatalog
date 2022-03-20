package com.app.easy;

import com.app.common.LinkedList;
import com.app.common.LinkedList.ListNode;

/**
 * @author t0k02w6 on 20/03/22
 * @project ds-algo-2021
 */
public class IntersectionOfTwoLinkedListLeetcode160 {
    private static int len(ListNode head) {
        int len = 0;
        ListNode temp = head;
        while(temp != null) {
            len++;
            temp = temp.next;
        }
        return len;
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        int lenA = len(headA);
        int lenB = len(headB);

        if(lenA < lenB) {
            ListNode temp = headA;
            headA = headB;
            headB = temp;

            int tmpLen = lenA;
            lenA = lenB;
            lenB = tmpLen;
        }
        ListNode tmpA = headA;
        ListNode tmpB = headB;
        if(lenA  > lenB) {
            int diff = (lenA - lenB);
            while(tmpA != null && diff > 0) {
                tmpA = tmpA.next;
                diff--;
            }
        }

        while(tmpA != null && tmpB != null) {
            if(tmpA == tmpB)
                return tmpA;
            tmpA = tmpA.next;
            tmpB = tmpB.next;
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
