package com.app.medium;

import com.app.common.BinaryTree.TreeNode;

public class MaximumAverageSubtreeLeetcode1120 {
    private static double maxAvg = 0;

    static class AvgItem {
        double sum;
        int count;

        public AvgItem(double sum, int count) {
            this.sum = sum;
            this.count = count;
        }
    }

    public static double maximumAverageSubtree(TreeNode root) {
        maxAvg = 0;
        avgRec(root);
        return maxAvg;
    }

    private static AvgItem avgRec(TreeNode root) {
        if(root == null)
            return new AvgItem(0, 0);
        AvgItem left = avgRec(root.left);
        AvgItem right = avgRec(root.right);

        double leftAvg = left.count == 0 ? 0: left.sum / left.count;
        double rightAvg = right.count == 0 ? 0: right.sum / right.count;

        AvgItem newItem = new AvgItem(root.val + left.sum + right.sum,
                1 + left.count + right.count);
        double currentAvg = newItem.sum / newItem.count;
        double currentVal = Double.max(currentAvg, Double.max(leftAvg, rightAvg));
        maxAvg = Double.max(maxAvg, currentVal);
        return newItem;
    }

    public static void main(String[] args) {

    }
}
