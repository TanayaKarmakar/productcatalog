package com.app.easy;

import com.app.common.BinaryTree.TreeNode;

/**
 * @author t0k02w6 on 21/03/22
 * @project ds-algo-2021
 */
public class SumOfLeftLeavesLeetcode404 {
    private static int sum = 0;

    public static int sumOfLeftLeaves(TreeNode root) {
        if(root == null)
            return 0;
        sumOfLeftLeavesRec(root, false);
        return sum;
    }

    private static void sumOfLeftLeavesRec(TreeNode root, boolean isLeft) {
        if(root == null)
            return;
        if(isLeft && root.left == null && root.right == null)
            sum += root.val;
        sumOfLeftLeavesRec(root.left, true);
        sumOfLeftLeavesRec(root.right, false);
    }

    public static void main(String[] args) {

    }
}
