package com.app.medium.design;

import java.util.Stack;

/**
 * @author t0k02w6 on 14/04/23
 * @project ds-algo-2021-leetcode
 */
public class ExpressionTreeLeetcode1628 {
  static abstract class Node {
    protected TreeNode root;

    public abstract int evaluate();
    // define your fields here

    static class TreeNode {
      String val;
      TreeNode left;
      TreeNode right;

      public TreeNode(String val) {
        this.val = val;
      }
    }
  }

  static class NodeImpl extends Node {

    @Override
    public int evaluate() {
      return evalRec(this.root);
    }

    private int evalRec(TreeNode root) {
      if(root == null)
        return 0;
      if(root.left == null && root.right == null)
        return Integer.parseInt(root.val);
      int left = evalRec(root.left);
      int right = evalRec(root.right);
      String current = root.val;
      int result = performOp(left, right, current);
      return result;
    }

    private int performOp(int left, int right, String current) {
      switch (current) {
        case "+":
          return left + right;
        case "-":
          return left - right;
        case "*":
          return left * right;
        case "/":
          return left / right;
        default:
          return 0;
      }
    }
  }

  static class TreeBuilder {

    private boolean isDigit(String token) {
      try {
        Integer.parseInt(token);
        return true;
      } catch (NumberFormatException nfe) {
        return false;
      }
    }

    Node buildTree(String[] postfix) {
      Stack<Integer> integerStack = new Stack<>();
      Stack<Node.TreeNode> nodeStack = new Stack<>();

      for(int i = 0; i < postfix.length; i++) {
        if(isDigit(postfix[i])) {
          nodeStack.push(new Node.TreeNode(postfix[i]));
        } else {

          Node.TreeNode node = new Node.TreeNode(postfix[i]);
          node.right = nodeStack.pop();
          node.left = nodeStack.pop();
          nodeStack.push(node);
        }
      }

      Node node = new NodeImpl();
      node.root = nodeStack.peek();
      return node;
    }


  }

  public static void main(String[] args) {

  }
}
