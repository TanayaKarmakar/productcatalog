package com.app.hard;

import com.app.common.BinaryTree.TreeNode;
/**
 * @author t0k02w6 on 23/05/23
 * @project ds-algo-2021-leetcode
 */
public class BinaryTreeMaximumPathSumLeetcode124 {
  private static int maxValue = 0;

  private static int maxPathSum(TreeNode root) {
    maxValue = Integer.MIN_VALUE;
    maxPathSumRec(root);
    return maxValue;
  }

  private static int maxPathSumRec(TreeNode root) {
    if(root == null)
      return 0;
    int leftSum = Integer.max(0,maxPathSumRec(root.left));
    int rightSum = Integer.max(0, maxPathSumRec(root.right));
    maxValue = Integer.max(maxValue, root.val + leftSum + rightSum);
    return root.val + Integer.max(leftSum, rightSum);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);


    int ans = maxPathSum(root);

    System.out.println(ans);

    root = new TreeNode(-10);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);

    ans = maxPathSum(root);

    System.out.println(ans);
  }
}
