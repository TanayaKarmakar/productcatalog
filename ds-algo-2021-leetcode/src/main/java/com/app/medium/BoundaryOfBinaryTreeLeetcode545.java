package com.app.medium;

import com.app.common.BinaryTree;
import com.app.common.BinaryTree.TreeNode;

import java.util.*;

/**
 * @author t0k02w6 on 16/04/22
 * @project ds-algo-2021
 */
public class BoundaryOfBinaryTreeLeetcode545 {
    private static void populateLeft(TreeNode root, List<Integer> res) {
        if(root == null)
            return;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            TreeNode remNode = q.poll();
            if(remNode.left == null && remNode.right == null)
                continue;
            res.add(remNode.val);
            if(remNode.left != null)
                q.add(remNode.left);
            else if(remNode.right != null)
                q.add(remNode.right);
        }
    }

    private static void populateLeaves(TreeNode root, List<Integer> res) {
        if(root == null)
            return;
        Stack<TreeNode> q = new Stack<>();
        q.add(root);

        while(!q.isEmpty()) {
            TreeNode rem = q.pop();
            if(rem.left == null && rem.right == null) {
                res.add(rem.val);
                continue;
            }

            if(rem.right != null)
                q.add(rem.right);
            if(rem.left != null)
                q.add(rem.left);
        }
    }

    private static void populateRight(TreeNode root, List<Integer> res) {
        if(root == null)
            return;
        List<Integer> temp = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            TreeNode remNode = q.poll();
            if(remNode.left == null && remNode.right == null)
                continue;
            temp.add(remNode.val);

            if(remNode.right != null)
                q.add(remNode.right);
            else if(remNode.left != null)
                q.add(remNode.left);
        }
        Collections.reverse(temp);
        res.addAll(temp);
    }

    private static List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        res.add(root.val);

        populateLeft(root.left, res);
        populateLeaves(root.left, res);
        populateLeaves(root.right, res);
        populateRight(root.right, res);
        return res;
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = new TreeNode(1);
        bt.root.left = new TreeNode(2);
        bt.root.right = new TreeNode(3);
        bt.root.left.left = new TreeNode(4);
        bt.root.left.right = new TreeNode(5);
        bt.root.left.right.left = new TreeNode(7);
        bt.root.left.right.right = new TreeNode(8);
        bt.root.right.left = new TreeNode(6);
        bt.root.right.left.left = new TreeNode(9);
        bt.root.right.left.right = new TreeNode(10);

        List<Integer> result = boundaryOfBinaryTree(bt.root);

        System.out.println(result);
    }
}
