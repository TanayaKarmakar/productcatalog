package com.app.medium;

/**
 * @author t0k02w6 on 22/04/23
 * @project ds-algo-2021-leetcode
 */

public class ConvertBinarySearchTreeToSortedLinkedListLeetcode426 {

  static class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
      val = _val;
      left = _left;
      right = _right;
    }
  };

  private static Node head;
  private static Node prev;

  private static Node treeToDoublyList(Node root) {
    if(root == null)
      return null;
    head = null;
    prev = null;
    dllRec(root);
    Node temp = head;
    while(temp.right != null) {
      temp = temp.right;
    }
    temp.right = head;
    head.left = temp;
    return head;
  }

  private static void dllRec(Node root) {
    if(root == null)
      return;
    dllRec(root.left);
    if(prev == null) {
      head = root;
    } else {
      prev.right = root;
      root.left = prev;
    }
    prev = root;
    dllRec(root.right);
  }

  public static void main(String[] args) {
    Node root = new Node(2);
    root.left = new Node(1);
    root.right = new Node(3);
//    root.left.left = new Node(1);
//    root.left.right = new Node(3);

    root = treeToDoublyList(root);

    Node temp = root;
    while(temp != null) {
      System.out.println(temp.val);
      temp = temp.right;
    }
  }
}
