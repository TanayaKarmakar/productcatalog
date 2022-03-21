package com.app.easy;

import com.app.common.BinaryTree.TreeNode;
/**
 * @author t0k02w6 on 21/03/22
 * @project ds-algo-2021
 */
public class ClosestBinarySearchTreeValueLeetcode270 {
    private static int value = 0;
    private static double diff = Integer.MAX_VALUE;

    private static void closestValueRec(TreeNode root, double target) {
        if(root == null)
            return;
        double currentDiff = Math.abs(root.val - target);
        if(currentDiff < diff) {
            diff = currentDiff;
            value = root.val;
        }
        if((double) root.val > target)
            closestValueRec(root.left, target);
        else
            closestValueRec(root.right, target);
    }

    private static int closestValue(TreeNode root, double target) {
        closestValueRec(root, target);
        return value;
    }

    public static void main(String[] args) {

    }
}
