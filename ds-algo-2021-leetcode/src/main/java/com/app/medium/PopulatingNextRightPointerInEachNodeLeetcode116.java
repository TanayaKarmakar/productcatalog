package com.app.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author t0k02w6 on 02/07/23
 * @project ds-algo-2021-leetcode
 */
public class PopulatingNextRightPointerInEachNodeLeetcode116 {
  static class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
      val = _val;
      left = _left;
      right = _right;
      next = _next;
    }
  };

  private static Node connect(Node root) {
    if(root == null)
      return root;
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    q.add(null);

    while(q.size() > 1) {
      Node remItem = q.poll();
      if(remItem == null) {
        q.add(null);
        continue;
      }

      if(q.peek() != null) {
        remItem.next = q.peek();
      }

      if(remItem.left != null)
        q.add(remItem.left);
      if(remItem.right != null)
        q.add(remItem.right);
    }
    return root;
  }


  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);

    root = connect(root);
  }
}
