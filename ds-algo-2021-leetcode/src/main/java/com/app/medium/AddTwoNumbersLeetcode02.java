package com.app.medium;

import com.app.common.LinkedList.ListNode;

public class AddTwoNumbersLeetcode02 {
    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        ListNode t1 = l1;
        ListNode t2 = l2;
        ListNode result = new ListNode(Integer.MAX_VALUE);
        ListNode t3 = result;

        int sum = 0;
        int carry = 0;
        while(t1 != null && t2 != null) {
            sum = t1.val + t2.val;

            if(carry != 0) {
                sum += carry;
            }

            if(sum > 9) {
                carry = sum / 10;
                sum = sum % 10;
            } else {
                carry = 0;
            }
            t3.next = new ListNode(sum);
            t3 = t3.next;

            t1 = t1.next;
            t2 = t2.next;
        }

        while(t1 != null) {
            sum = t1.val;

            if(carry > 0) {
                sum += carry;
            }

            if(sum > 9) {
                carry = sum / 10;
                sum = sum % 10;
            } else {
                carry = 0;
            }

            t3.next = new ListNode(sum);
            t3 = t3.next;

            t1 = t1.next;
        }

        while(t2 != null) {
            sum = t2.val;

            if(carry > 0) {
                sum += carry;
            }

            if(sum > 9) {
                carry = sum / 10;
                sum = sum % 10;
            } else {
                carry = 0;
            }

            t3.next = new ListNode(sum);
            t3 = t3.next;

            t2 = t2.next;
        }

        if(carry != 0) {
            t3.next = new ListNode(carry);
            t3 = t3.next;
        }

        result = result.next;
        return result;
    }

    public static void main(String[] args) {

    }
}
