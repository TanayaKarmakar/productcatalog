package com.app.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author t0k02w6 on 17/10/22
 * @project ds-algo-2021-leetcode
 */
public class PopulatingNextRightPointerLeetcode116 {
  class Node {
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

  private static Node connect(Node root) {
    if(root == null)
      return root;
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    q.add(null);

    while(q.size() > 1) {
      Node remNode = q.poll();
      if(remNode == null) {
        q.add(null);
        continue;
      }

      if(q.peek() != null)
        remNode.next = q.peek();
      if(remNode.left != null)
        q.add(remNode.left);
      if(remNode.right != null)
        q.add(remNode.right);
    }
    return root;
  }

  public static void main(String[] args) {

  }
}
