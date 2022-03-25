package com.app.medium;

import com.app.common.BinaryTree;
import com.app.common.BinaryTree.TreeNode;

/**
 * @author t0k02w6 on 24/03/22
 * @project ds-algo-2021
 */
public class LowestCommonAncestorLeetcode236 {
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
