package com.app.easy;

import com.app.common.BinaryTree.TreeNode;

public class BalancedBinaryTreeLeetcode110 {
    private static boolean isBalanced(TreeNode root) {
        int ans = balancedRec(root);
        if(ans == -1)
            return false;
        return true;
    }

    private static int balancedRec(TreeNode root) {
        if(root == null)
            return 0;
        int left = balancedRec(root.left);
        if(left == -1)
            return -1;
        int right = balancedRec(root.right);
        if(right == -1)
            return -1;
        int diff = Math.abs(left - right);
        if(diff > 1)
            return -1;
        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {

    }
}
