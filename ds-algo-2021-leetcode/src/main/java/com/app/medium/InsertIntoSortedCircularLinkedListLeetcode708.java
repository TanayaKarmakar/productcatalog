package com.app.medium;

/**
 * @author t0k02w6 on 03/07/23
 * @project ds-algo-2021-leetcode
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
    Node newNode = new Node(insertVal);
    if(head == null) {
      newNode.next = newNode;
      return newNode;
    }

    Node curr = head;
    while(curr.next != head) {
      int currentVal = curr.val;
      int nextVal = curr.next.val;
      if(insertVal >= currentVal && insertVal <= nextVal) {
        break;
      } else if(currentVal > nextVal) {
        if(insertVal <= currentVal && insertVal <= nextVal)
          break;
        if(insertVal >= currentVal && insertVal >= nextVal)
          break;
      }
      curr = curr.next;
    }
    Node next = curr.next;
    newNode.next = next;
    curr.next = newNode;

    return head;
  }

  public static void main(String[] args) {

  }
}
