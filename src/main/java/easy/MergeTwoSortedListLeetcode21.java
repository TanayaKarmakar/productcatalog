package easy;

import common.ListNode;

/**
 * @author t0k02w6 on 08/02/22
 * @project ds-algo-2021
 */
public class MergeTwoSortedListLeetcode21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;
        ListNode result = new ListNode(Integer.MAX_VALUE);
        ListNode tmp1 = list1;
        ListNode tmp2 = list2;

        ListNode tmp = result;

        while(tmp1 != null && tmp2 != null) {
            if(tmp1.val < tmp2.val) {
                tmp.next = tmp1;
                tmp1 = tmp1.next;
            } else {
                tmp.next = tmp2;
                tmp2 = tmp2.next;
            }
            tmp = tmp.next;
        }

        if(tmp1 != null)
            tmp.next = tmp1;
        if(tmp2 != null)
            tmp.next = tmp2;
        result = result.next;
        return result;
    }
}
