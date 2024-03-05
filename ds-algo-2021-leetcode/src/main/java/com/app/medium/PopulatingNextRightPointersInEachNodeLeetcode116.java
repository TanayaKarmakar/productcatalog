package com.app.medium;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNodeLeetcode116 {
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
        if(root == null || (root.left == null && root.right == null))
            return root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while(queue.size() > 1) {
            Node remNode = queue.poll();
            if(remNode == null) {
                queue.add(null);
                continue;
            }

            if(queue.peek() != null) {
                remNode.next = queue.peek();
            }

            if(remNode.left != null)
                queue.add(remNode.left);
            if(remNode.right != null)
                queue.add(remNode.right);
        }
        return root;
    }

    public static void main(String[] args) {

    }
}
