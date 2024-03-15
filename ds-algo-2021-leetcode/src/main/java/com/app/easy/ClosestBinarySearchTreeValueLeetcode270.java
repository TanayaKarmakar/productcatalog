package com.app.easy;

import com.app.common.BinaryTree.TreeNode;

public class ClosestBinarySearchTreeValueLeetcode270 {
    private static double diff = Integer.MAX_VALUE;
    private static int nodeVal = 0;

    private static int closestValue(TreeNode root, double target) {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return root.val;
        diff = Integer.MAX_VALUE;
        nodeVal = 0;
        closestValueRec(root, target);
        return nodeVal;
    }

    private static void closestValueRec(TreeNode root, double target) {
        if(root == null)
            return;
        double currentDiff = Math.abs((double) root.val - target);
        if(currentDiff < diff) {
            diff = currentDiff;
            nodeVal = root.val;
        }
        if((double) root.val > target)
            closestValueRec(root.left, target);
        else
            closestValueRec(root.right, target);
    }


    public static void main(String[] args) {

    }
}
