package com.app.medium;

import com.app.common.LinkedList;
import com.app.common.LinkedList.ListNode;

/**
 * @author t0k02w6 on 22/03/22
 * @project ds-algo-2021
 */
public class AddTwoNumbersLeetcode2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        ListNode tmp1 = l1;
        ListNode tmp2 = l2;

        ListNode result = new ListNode(Integer.MAX_VALUE);
        ListNode tmp3 = result;

        int carry = 0;

        while(tmp1 != null && tmp2 != null) {
            int sum = tmp1.val + tmp2.val + carry;
            carry = sum / 10;
            sum = sum % 10;

            ListNode newNode = new ListNode(sum);
            tmp3.next = newNode;
            tmp3 = tmp3.next;

            tmp1 = tmp1.next;
            tmp2 = tmp2.next;
        }

        while(tmp1 != null) {
            int sum = tmp1.val + carry;
            carry = sum / 10;
            sum = sum % 10;

            ListNode newNode = new ListNode(sum);
            tmp3.next = newNode;
            tmp3 = tmp3.next;

            tmp1 = tmp1.next;
        }

        while(tmp2 != null) {
            int sum = tmp2.val + carry;
            carry = sum /10;
            sum = sum % 10;

            ListNode newNode = new ListNode(sum);
            tmp3.next = newNode;
            tmp3 = tmp3.next;

            tmp2 = tmp2.next;
        }

        if(carry != 0) {
            tmp3.next = new ListNode(carry);
            tmp3 = tmp3.next;
        }

        result = result.next;
        return result;
    }

    public static void main(String[] args) {

    }
}
