package com.app.easy;

import com.app.common.BinaryTree.TreeNode;

/**
 * @author t0k02w6 on 15/03/22
 * @project ds-algo-2021
 */
public class PathSumLeetcode112 {
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        return hasPathSumRec(root, targetSum, 0);
    }

    private static boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }

    private static boolean hasPathSumRec(TreeNode root, int targetSum, int sumSoFar) {
        if(root == null)
            return false;
        if(isLeaf(root)) {
            if(targetSum == sumSoFar + root.val)
                return true;
            return false;
        }
        sumSoFar += root.val;
        boolean isLeft = hasPathSumRec(root.left, targetSum, sumSoFar);
        boolean isRight = hasPathSumRec(root.right, targetSum, sumSoFar);
        return (isLeft || isRight);
    }

    public static void main(String[] args) {

    }
}
