package com.app.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author t0k02w6 on 05/12/22
 * @project ds-algo-2021
 */
public class PopulatingNextRightPointersInEachNodeII {
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
      return null;
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    q.add(null);


    while(!q.isEmpty()) {
      Node item = q.poll();
      if(item == null) {
        if(q.size() > 0)
          q.add(null);
        continue;
      }
      if(q.peek() != null)
        item.next = q.peek();

      if(item.left != null)
        q.add(item.left);
      if(item.right != null)
        q.add(item.right);
    }

    return root;
  }

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.right = new Node(7);

    root = connect(root);
  }
}
