package com.app.medium;

/**
 * @author t0k02w6 on 29/09/22
 * @project ds-algo-2021-leetcode
 */
public class ConvertBinarySearchTreeToSortedDoublyLinkedListLeetcode426 {
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

    private static Node prev = null;
    private static Node head = null;

    private static void convertRec(Node root) {
        if(root == null)
            return;
        convertRec(root.left);
        if(prev == null)
            head = root;
        else {
            root.left = prev;
            prev.right = root;

        }
        prev = root;
        convertRec(root.right);
    }

    private static Node treeToDoublyList(Node root) {
        if(root == null)
            return null;
        convertRec(root);
        Node temp = head;
        while(temp.right != null) {
            temp = temp.right;
        }
        temp.right = head;
        head.left = temp;
        return head;
    }

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(3);

        treeToDoublyList(root);

        Node temp = head;
        while(temp != null) {
            System.out.println(temp.val);
            temp = temp.right;
        }


    }
}
