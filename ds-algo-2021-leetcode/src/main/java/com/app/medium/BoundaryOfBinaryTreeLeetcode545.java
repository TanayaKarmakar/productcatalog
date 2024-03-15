package com.app.medium;

import java.util.*;

import com.app.common.BinaryTree.TreeNode;

public class BoundaryOfBinaryTreeLeetcode545 {
    private static List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        result.add(root.val);
        traverseLeft(root.left, result);
        traverseBottom(root.left, result);
        traverseBottom(root.right, result);
        traverseRight(root.right, result);
        return result;
    }

    private static void traverseBottom(TreeNode root, List<Integer> result) {
        if(root == null)
            return;
        if(root.left == null && root.right == null) {
            result.add(root.val);
        }
        traverseBottom(root.left, result);
        traverseBottom(root.right, result);
    }

    private static void traverseRight(TreeNode root, List<Integer> result) {
        if(root == null)
            return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        List<Integer> temp = new ArrayList<>();

        while(!queue.isEmpty()) {
           TreeNode remNode = queue.poll();
           if(remNode.left == null && remNode.right == null)
               continue;
           temp.add(remNode.val);

           if(remNode.right != null)
               queue.add(remNode.right);
           else if(remNode.left != null)
               queue.add(remNode.left);

        }

        Collections.reverse(temp);
        result.addAll(temp);
    }

    private static void traverseLeft(TreeNode root, List<Integer> result) {
        if(root == null)
            return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode remNode = queue.poll();
            if(remNode.left == null && remNode.right == null)
                continue;
            result.add(remNode.val);

            if(remNode.left != null)
                queue.add(remNode.left);
            else if(remNode.right != null)
                queue.add(remNode.right);
        }
    }

    public static void main(String[] args) {

    }
}
