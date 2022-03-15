package com.app.easy;

import com.app.common.BinaryTree;
import com.app.common.BinaryTree.TreeNode;

/**
 * @author t0k02w6 on 15/03/22
 * @project ds-algo-2021
 */
public class BalancedBinaryTreeLeetcode110 {
    private static boolean isBalanced(TreeNode root) {
        int balanced = isBalancedRec(root);
        if(balanced == -1)
            return false;
        return true;
    }

    private static int isBalancedRec(TreeNode root) {
        if(root == null)
            return 0;
        int left = isBalancedRec(root.left);
        if(left == -1)
            return -1;
        int right = isBalancedRec(root.right);
        if(right == -1)
            return -1;
        int diff = Math.abs(left - right);
        if(diff > 1)
            return -1;
        return 1 + Integer.max(left, right);
    }

    public static void main(String[] args) {

    }
}
