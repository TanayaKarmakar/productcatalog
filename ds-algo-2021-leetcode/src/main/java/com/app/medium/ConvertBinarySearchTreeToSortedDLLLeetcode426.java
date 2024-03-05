package com.app.medium;

public class ConvertBinarySearchTreeToSortedDLLLeetcode426 {
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
    }

    static Node prev;
    static Node head;


    private static Node treeToDoublyList(Node root) {
        if(root == null)
            return null;
        prev = null;
        head = null;
        dllRec(root);
        Node temp = head;
        while(temp.right != null) {
            temp = temp.right;
        }
        head.left = temp;
        temp.right = head;
        return head;
    }

    private static void dllRec(Node root) {
        if(root == null)
            return;
        dllRec(root.left);
        if(prev == null) {
            head = root;
        } else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        dllRec(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(3);

        Node head = treeToDoublyList(root);
        Node temp = head;

        while(temp != null) {
            System.out.println(temp.val);
            temp = temp.right;
        }
    }
}
