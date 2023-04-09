package com.app.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author t0k02w6 on 07/04/23
 * @project ds-algo-2021-leetcode
 */
public class PopulatingNextRightPointerIILeetcode117 {
  private static Node connect(Node root) {
    if(root == null)
      return null;
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    q.add(null);

    while(q.size() > 1) {
      Node node = q.poll();
      if(node == null) {
        q.add(null);
        continue;
      }

      if(!q.isEmpty()) {
        node.next = q.peek();
      }

      if(node.left!= null)
        q.add(node.left);
      if(node.right != null)
        q.add(node.right);
    }

    return root;
  }

  public static void main(String[] args) {

  }

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
  }
}
