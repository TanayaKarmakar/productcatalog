package com.app.easy;

import com.app.common.BinaryTree.TreeNode;

public class InvertBinaryTreeLeetcode226 {
    private static TreeNode invertTree(TreeNode root) {
        if(root == null || (root.left == null && root.right == null))
            return root;
        insertTreeRec(root);
        return root;
    }

    private static TreeNode insertTreeRec(TreeNode root) {
        if(root == null)
            return null;
        root.left = insertTreeRec(root.left);
        root.right = insertTreeRec(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }


    public static void main(String[] args) {

    }
}
