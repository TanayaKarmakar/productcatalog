package com.app.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author t0k02w6 on 17/04/22
 * @project ds-algo-2021
 */
public class PopulatingNextRightPointerLeetcode116 {
    private static Node connect(Node root) {
        if(root == null || (root.left == null && root.right == null))
            return root;
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            int size = q.size();

            for(int i = 0; i < size; i++) {
                Node remNode = q.poll();
                if(i != size - 1)
                    remNode.next = q.peek();
                if(remNode.left != null)
                    q.add(remNode.left);
                if(remNode.right != null)
                    q.add(remNode.right);
            }
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
    };
}
