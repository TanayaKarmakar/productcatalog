package com.app.easy;

import com.app.common.BinaryTree.TreeNode;

public class MaximumDepthOfBinaryTreeLeetcode104 {
    private static int maxDepth(TreeNode root) {
        return height(root);
    }

    private static int height(TreeNode root) {
        if(root == null)
            return 0;
        int left = height(root.left);
        int right = height(root.right);
        return 1 + Integer.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int ans = maxDepth(root);

        System.out.println(ans);
    }
}
