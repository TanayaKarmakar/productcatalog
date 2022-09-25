package com.app.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 22/09/22
 * @project ds-algo-2021-leetcode
 */
public class CopyListWithRandomPointerLeetcode138 {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    private static Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node temp = head;
        while(temp != null) {
            Node newNode = new Node(temp.val);
            map.put(temp, newNode);
            temp = temp.next;
        }

        temp = head;
        while(temp != null) {
            Node next = temp.next;
            Node random = temp.random;
            map.get(temp).next = map.get(next);
            map.get(temp).random = map.get(random);
            temp = temp.next;
        }
        return map.get(head);
    }

    public static void main(String[] args) {

    }
}
