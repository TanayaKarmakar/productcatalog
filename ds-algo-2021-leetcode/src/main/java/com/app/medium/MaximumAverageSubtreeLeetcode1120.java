package com.app.medium;

import com.app.common.BinaryTree.TreeNode;

/**
 * @author t0k02w6 on 06/07/23
 * @project ds-algo-2021-leetcode
 */
public class MaximumAverageSubtreeLeetcode1120 {
  static class AvgItem {
    double total;
    int count;

    public AvgItem(double total, int count) {
      this.total = total;
      this.count = count;
    }
  }

  private static double maxAvg;

  private static double maximumAverageSubtree(TreeNode root) {
    maxAvg = 0;
    maximumAverageRec(root);
    return maxAvg;
  }

  private static AvgItem maximumAverageRec(TreeNode root) {
    if(root == null) {
      return new AvgItem(0.0, 0);
    }

    AvgItem lAvg = maximumAverageRec(root.left);
    AvgItem rAvg = maximumAverageRec(root.right);

    double total = lAvg.total + rAvg.total + root.val;
    int count = lAvg.count + rAvg.count + 1;
    AvgItem currentAvgItem = new AvgItem(total, count);

    double option1 = 0;
    if(lAvg.total > 0) {
      option1 = lAvg.total / lAvg.count;
    }

    double option2 = 0;
    if(rAvg.total > 0) {
      option2 = rAvg.total / rAvg.count;
    }

    double option3 = currentAvgItem.total / currentAvgItem.count;
    double currentAvg = Double.max(option1, Double.max(option2, option3));
    maxAvg = Double.max(currentAvg, maxAvg);
    return currentAvgItem;
  }


  public static void main(String[] args) {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(6);
    root.right = new TreeNode(1);

    double ans = maximumAverageSubtree(root);

    System.out.println(ans);
  }
}
