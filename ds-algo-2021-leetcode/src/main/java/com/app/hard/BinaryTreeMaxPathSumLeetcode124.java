package com.app.hard;


import com.app.common.BinaryTree.TreeNode;

/**
 * @author t0k02w6 on 29/01/23
 * @project ds-algo-2021
 */
public class BinaryTreeMaxPathSumLeetcode124 {
  private static int maxPathSum(TreeNode root) {
    int[] maxValue = new int[1];
    maxValue[0] = Integer.MIN_VALUE;
    maxPathDown(root, maxValue);
    return maxValue[0];
  }

  private static int maxPathDown(TreeNode root, int[] maxValue) {
    if(root == null)
      return 0;
    int left = Integer.max(0, maxPathDown(root.left, maxValue));
    int right = Integer.max(0, maxPathDown(root.right, maxValue));
    maxValue[0] = Integer.max(maxValue[0], left + right + root.val);
    return root.val + Integer.max(left, right);
  }

  public static void main(String[] args) {

  }
}
