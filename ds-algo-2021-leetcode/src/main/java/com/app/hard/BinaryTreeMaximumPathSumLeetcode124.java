package com.app.hard;

import com.app.common.BinaryTree.TreeNode;

public class BinaryTreeMaximumPathSumLeetcode124 {
    private static int maxValue = 0;
    private static int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        maxPathSumRec(root);
        return maxValue;
    }

    private static int maxPathSumRec(TreeNode root) {
        if(root == null)
            return 0;
        int left = Integer.max(0, maxPathSumRec(root.left));
        int right = Integer.max(0, maxPathSumRec(root.right));
        maxValue = Integer.max(maxValue, root.val + left + right);
        return root.val + Integer.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int ans = maxPathSum(root);

        System.out.println(ans);
    }
}
