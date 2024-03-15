package com.app.easy;

import com.app.common.BinaryTree.TreeNode;


public class SymmetricTreeLeetcode101 {
    private static boolean isSymmetric(TreeNode root) {
        if(root == null || (root.left == null && root.right == null))
            return true;
        return isSymmetricRec(root.left, root.right);
    }

    private static boolean isSymmetricRec(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null)
            return true;
        if(root1 == null || root2 == null)
            return false;
        return root1.val == root2.val &&
                isSymmetricRec(root1.left, root2.right) &&
                isSymmetricRec(root1.right, root2.left);

    }

    public static void main(String[] args) {

    }
}
