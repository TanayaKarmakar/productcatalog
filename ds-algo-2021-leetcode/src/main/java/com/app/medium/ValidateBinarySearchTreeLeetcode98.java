package com.app.medium;

import com.app.common.BinaryTree.TreeNode;

public class ValidateBinarySearchTreeLeetcode98 {
    private static boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        return validate(root, 2L * Integer.MIN_VALUE, 2L * Integer.MAX_VALUE);
    }

    private static boolean validate(TreeNode root, long min, long max) {
        if(root == null)
            return true;
        if(root.val <= min || root.val >= max)
            return false;
        return validate(root.left, min, root.val)
                && validate(root.right, root.val, max);
    }

    public static void main(String[] args) {

    }
}
