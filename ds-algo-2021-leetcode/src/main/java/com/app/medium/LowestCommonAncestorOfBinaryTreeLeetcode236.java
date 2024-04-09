package com.app.medium;

import com.app.common.BinaryTree.TreeNode;

public class LowestCommonAncestorOfBinaryTreeLeetcode236 {
    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
        if(root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null)
            return root;
        else if(left != null)
            return left;
        else
            return right;
    }

    public static void main(String[] args) {

    }
}
