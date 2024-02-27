package com.app.medium;

import java.util.HashMap;
import java.util.Map;

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
        Map<Node, Node> nodeMap = new HashMap<>();
        Node temp = head;
        while(temp != null) {
            Node newNode = new Node(temp.val);
            nodeMap.put(temp, newNode);
            temp = temp.next;
        }

        for(Map.Entry<Node, Node> entry: nodeMap.entrySet()) {
            entry.getValue().next = nodeMap.get(entry.getKey().next);
            entry.getValue().random = nodeMap.get(entry.getKey().random);
        }

        return nodeMap.get(head);

    }

    public static void main(String[] args) {

    }
}
