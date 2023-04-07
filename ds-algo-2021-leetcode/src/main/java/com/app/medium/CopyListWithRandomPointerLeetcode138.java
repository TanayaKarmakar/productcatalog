package com.app.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 06/02/23
 * @project ds-algo-2021
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
    Map<Node, Node> nodeMap = new HashMap<>();

    Node temp = head;
    while(temp != null) {
      nodeMap.put(temp, new Node(temp.val));
      temp = temp.next;
    }

    temp = head;
    while(temp != null) {
      nodeMap.get(temp).next = nodeMap.get(temp.next);

      if(nodeMap.containsKey(temp.random))
        nodeMap.get(temp).random = nodeMap.get(temp.random);
      temp = temp.next;
    }

    return nodeMap.get(head);
  }

  public static void main(String[] args) {

  }
}
