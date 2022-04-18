package com.app.medium;

/**
 * @author t0k02w6 on 17/04/22
 * @project ds-algo-2021
 */
public class InsertIntoSortedCircularLinkedListLeetcode708 {
    static class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    };

    private static Node insert(Node head, int insertVal) {
        if(head == null) {
            head = new Node(insertVal);
            head.next = head;
            return head;
        }
        if(head.next == head) {
            Node newNode = new Node(insertVal);
            newNode.next = head;
            head.next = newNode;
            return head;
        }

        Node tmp = head;
        while(true) {
            if(canInsert(tmp, insertVal)) {
                Node newNode = new Node(insertVal);
                newNode.next = tmp.next;
                tmp.next = newNode;
                break;
            }
            if(tmp.next == head) {
                Node newNode = new Node(insertVal);
                newNode.next = head;
                tmp.next = newNode;
                break;
            }
            tmp = tmp.next;
        }
        return head;
    }

    private static boolean canInsert(Node tmp, int insertVal) {
        if(insertVal >= tmp.val && insertVal < tmp.next.val)
            return true;
        else if(insertVal >= tmp.val && tmp.val > tmp.next.val)
            return true;
        else if(insertVal < tmp.val && insertVal <tmp.next.val && tmp.val > tmp.next.val)
            return true;
        return false;
    }

    public static void main(String[] args) {

    }
}
