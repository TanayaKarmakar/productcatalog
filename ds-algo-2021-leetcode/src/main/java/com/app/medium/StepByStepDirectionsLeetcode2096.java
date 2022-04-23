package com.app.medium;

import com.app.common.BinaryTree;
import com.app.common.BinaryTree.TreeNode;
import com.app.common.Pair;

import java.util.*;

/**
 * @author t0k02w6 on 21/04/22
 * @project ds-algo-2021
 */
public class StepByStepDirectionsLeetcode2096 {
    static String path = "";
    static boolean found = false;

    private static String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode ancestor = lca(root, startValue, destValue);

        StringBuilder sb = new StringBuilder();

        StringBuilder finalPath = new StringBuilder();
        traverse(ancestor, startValue, sb);
        for(int i = 0; i < path.length(); i++) {
            finalPath.append("U");
        }

        sb = new StringBuilder();
        traverse(ancestor, destValue, sb);
        finalPath.append(path);

        return finalPath.toString();
    }

    private static void traverse(TreeNode root, int value, StringBuilder sb) {
        if(root == null)
            return;
        if(root.val == value) {
            path = sb.toString();
            return;
        }
        traverse(root.left, value, sb.append("L"));
        sb.deleteCharAt(sb.length() - 1);

        traverse(root.right, value, sb.append("R"));
        sb.deleteCharAt(sb.length() - 1);
    }

    private static TreeNode lca(TreeNode root, int startValue, int endValue) {
        if(root == null)
            return null;
        if(root.val == startValue || root.val == endValue)
            return root;
        TreeNode left = lca(root.left, startValue, endValue);
        TreeNode right = lca(root.right, startValue, endValue);
        if(left != null && right != null)
            return root;
        else if(left != null)
            return left;
        else
            return right;
    }



    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
//        bt.root = new TreeNode(5);
//        bt.root.left = new TreeNode(1);
//        bt.root.right = new TreeNode(2);
//        bt.root.left.left = new TreeNode(3);
//        bt.root.right.left = new TreeNode(6);
//        bt.root.right.right = new TreeNode(4);

        bt.root = new TreeNode(7);
        bt.root.left = new TreeNode(8);
        bt.root.right = new TreeNode(3);
        bt.root.left.left = new TreeNode(1);
        bt.root.right.left = new TreeNode(4);
        bt.root.right.right = new TreeNode(5);
        bt.root.left.left.left = new TreeNode(6);
        bt.root.right.right.right = new TreeNode(2);

        String res = getDirections(bt.root, 7, 5);
        System.out.println(res);
    }
}
