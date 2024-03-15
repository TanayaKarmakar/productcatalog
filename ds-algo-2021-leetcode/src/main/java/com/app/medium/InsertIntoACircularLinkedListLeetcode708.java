package com.app.medium;

public class InsertIntoACircularLinkedListLeetcode708 {
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
    }

    private static Node insert(Node head, int insertVal) {
        if(head == null) {
            head = new Node(insertVal);
            head.next = head;
            return head;
        }

        Node curr = head;
        while(curr.next != head) {
            int currV = curr.val;
            int nextV = curr.next.val;

            if(currV <= insertVal && insertVal <= nextV) {
                break;
            } else if(currV > nextV) {
                if((currV <= insertVal && nextV <= insertVal) ||
                        (currV >= insertVal && nextV >= insertVal))
                    break;
            }
            curr = curr.next;
        }

        Node node = new Node(insertVal);
        node.next = curr.next;
        curr.next = node;

        return head;
    }

    public static void main(String[] args) {

    }
}
