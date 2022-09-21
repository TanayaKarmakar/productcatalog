package com.app.medium;

import com.app.common.BinaryTree.TreeNode;

/**
 * @author t0k02w6 on 21/09/22
 * @project ds-algo-2021-leetcode
 */
public class StepByStepDirectionsOfBinaryTreeLeetcode2096 {
    private static String path;

    private static String getDirections(TreeNode root, int startValue, int destValue) {
        if(root == null)
            return "";
        TreeNode ancestor = lca(root, startValue, destValue);
        StringBuilder finalPath = new StringBuilder();
        StringBuilder distance = new StringBuilder();
        getDistance(ancestor, startValue, distance);
        for(int i = 0; i < path.length(); i++) {
            finalPath.append("U");
        }

        distance = new StringBuilder();
        getDistance(ancestor, destValue, distance);
        finalPath.append(path);
        return finalPath.toString();
    }

    private static void getDistance(TreeNode root, int value, StringBuilder sb) {
        if(root == null)
            return;
        if(root.val == value) {
            path = sb.toString();
            return;
        }

        getDistance(root.left, value, sb.append("L"));
        sb.deleteCharAt(sb.length() - 1);

        getDistance(root.right, value, sb.append("R"));
        sb.deleteCharAt(sb.length() - 1);
    }

    private static TreeNode lca(TreeNode root, int p, int q) {
        if(root == null)
            return null;
        if(root.val == p || root.val == q)
            return root;
        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);
        if(left != null && right != null)
            return root;
        else if(left != null)
            return left;
        else
            return right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(4);

        String str = getDirections(root, 3, 6);

        System.out.println(str);
    }
}
