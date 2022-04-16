package com.app.medium;

import com.app.common.BinaryTree;
import com.app.common.BinaryTree.TreeNode;

/**
 * @author t0k02w6 on 14/04/22
 * @project ds-algo-2021
 */
public class ValidateBinarySearchTreeLeetcode98 {
    private static boolean isValidBSTRec(TreeNode root, long min, long max) {
        if(root == null)
            return true;
        if(root.val > min && root.val < max) {
            boolean l = true;
            boolean r = true;
            if(root.left != null)
                l = isValidBSTRec(root.left, min, root.val);
            if(root.right != null)
                r = isValidBSTRec(root.right, root.val, max);
            return (l && r);
        }
        return false;
    }

    private static boolean isValidBST(TreeNode root) {
        if(root == null || (root.left == null && root.right == null))
            return true;
        return  isValidBSTRec(root, (2L *Integer.MIN_VALUE), (2L *Integer.MAX_VALUE));
    }

    public static void main(String[] args) {

    }
}
