package com.app.medium.design;

import java.util.Stack;

/**
 * @author t0k02w6 on 18/11/22
 * @project ds-algo-2021
 */

abstract class Node {
  public abstract int evaluate();
  // define your fields here

  TreeNode root;

  static class TreeNode {
    String data;
    TreeNode left;
    TreeNode right;
  }

};

class NodeImpl extends Node {
  private int finalValue = 0;

  private int evalRec(TreeNode root) {
    if(root == null)
      return 0;
    if(root.left == null && root.right == null)
      return Integer.parseInt(root.data);
    int left = evalRec(root.left);
    int right = evalRec(root.right);

    String current = root.data;
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


  @Override
  public int evaluate() {
    TreeNode root = this.root;
    return evalRec(root);
  }
}

class TreeBuilder {
  private boolean isDigit(String token) {
    try {
      int value = Integer.parseInt(token);
      return true;
    } catch (NumberFormatException nfe) {
      return false;
    }
  }

  Node buildTree(String[] postfix) {
    Stack<Integer> integerStack = new Stack<>();
    Stack<Node.TreeNode> nodeStack = new Stack<>();

    for(String token: postfix) {
      if(isDigit(token)) {
        //integerStack.push(Integer.parseInt(token));
        Node.TreeNode node = new Node.TreeNode();
        node.data = token;
        nodeStack.push(node);
      } else {
        Node.TreeNode currentNode = new Node.TreeNode();
        currentNode.data = token;

        Node.TreeNode rightNode = nodeStack.pop();
        currentNode.left = nodeStack.pop();
        currentNode.right = rightNode;
        nodeStack.push(currentNode);
      }
    }
    Node node = new NodeImpl();
    node.root = nodeStack.peek();
    return node;
  }

};

public class ExpressionTreeLeetcode1628 {
}
