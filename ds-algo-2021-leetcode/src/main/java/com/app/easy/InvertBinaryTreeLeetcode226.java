package com.app.easy;

import com.app.common.BinaryTree;
import com.app.common.BinaryTree.TreeNode;

/**
 * @author t0k02w6 on 19/03/22
 * @project ds-algo-2021
 */
public class InvertBinaryTreeLeetcode226 {
    private static TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        TreeNode tmp = left;
        left = right;
        right = tmp;

        root.left = left;
        root.right = right;

        return root;
    }

    public static void main(String[] args) {

    }
}
