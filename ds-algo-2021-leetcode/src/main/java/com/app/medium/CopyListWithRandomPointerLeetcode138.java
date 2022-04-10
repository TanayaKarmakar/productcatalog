package com.app.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 09/04/22
 * @project ds-algo-2021
 */
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyListWithRandomPointerLeetcode138 {
    private static Node copyRandomList(Node head) {
        Map<Node, Node> nodeMap = new HashMap<>();

        Node temp = head;
        while(temp != null) {
            nodeMap.put(temp, new Node(temp.val));
            temp = temp.next;
        }

        for(Map.Entry<Node, Node> node: nodeMap.entrySet()) {
            Node newNode = node.getValue();
            Node origNode = node.getKey();

            if(origNode.next != null) {
                newNode.next = nodeMap.get(origNode.next);
            }

            if(origNode.random != null) {
                newNode.random = nodeMap.get(origNode.random);
            }
        }
        return nodeMap.get(head);
    }

    public static void main(String[] args) {

    }
}
