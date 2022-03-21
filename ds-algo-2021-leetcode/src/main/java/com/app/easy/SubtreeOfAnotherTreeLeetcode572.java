package com.app.easy;

import com.app.common.BinaryTree;
import com.app.common.BinaryTree.TreeNode;

/**
 * @author t0k02w6 on 21/03/22
 * @project ds-algo-2021
 */
public class SubtreeOfAnotherTreeLeetcode572 {
    private static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null)
            return false;
        if(root.val == subRoot.val) {
            boolean ans = isEqual(root, subRoot);
            if(ans)
                return true;
        }
        boolean lAns = isSubtree(root.left, subRoot);
        boolean rAns = isSubtree(root.right, subRoot);
        return lAns || rAns;
    }

    private static boolean isEqual(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null)
            return true;
        if(root == null || subRoot == null)
            return false;
        return root.val == subRoot.val && isEqual(root.left, subRoot.left)
                && isEqual(root.right, subRoot.right);
    }

    public static void main(String[] args) {

    }
}
