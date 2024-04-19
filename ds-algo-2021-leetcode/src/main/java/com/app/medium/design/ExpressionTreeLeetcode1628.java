package com.app.medium.design;

import java.util.Stack;

public class ExpressionTreeLeetcode1628 {
    static abstract class Node {
        protected TreeNode root;
        public abstract int evaluate();
        // define your fields here

        static class TreeNode {
            String value;
            TreeNode left;
            TreeNode right;

            public TreeNode(String value) {
                this.value = value;
            }
        }
    };

    static class NodeImpl extends Node {

        @Override
        public int evaluate() {
            return evalRec(this.root);
        }

        private int evalRec(TreeNode root) {
            if(root.left == null && root.right == null)
                return Integer.parseInt(root.value);
            int left = evalRec(root.left);
            int right = evalRec(root.right);
            return performOp(left, right, root.value);
        }

        private int performOp(int left, int right, String value) {
            switch (value) {
                case "+":
                    return left + right;
                case "-":
                    return left - right;
                case "*":
                    return left * right;
                case "/":
                    return left / right;
                default:
                    throw new RuntimeException("Illegal operation");
            }
        }
    }


    static class TreeBuilder {
        Node buildTree(String[] postfix) {
            Stack<Node.TreeNode> expr = new Stack<>();
            for(int i = 0; i < postfix.length; i++) {
                String token = postfix[i];
                if(isDigit(token)) {
                    expr.push(new Node.TreeNode(token));
                } else {
                    Node.TreeNode right = expr.pop();
                    Node.TreeNode left = expr.pop();
                    Node.TreeNode newNode = new Node.TreeNode(token);
                    newNode.left = left;
                    newNode.right = right;
                    expr.push(newNode);
                }
            }
            Node node = new NodeImpl();
            node.root = expr.peek();
            return node;
        }

        private boolean isDigit(String token) {
            try {
                Integer.parseInt(token);
                return true;
            } catch (NumberFormatException nfe) {
                return false;
            }
        }
    };

    public static void main(String[] args) {

    }
}
