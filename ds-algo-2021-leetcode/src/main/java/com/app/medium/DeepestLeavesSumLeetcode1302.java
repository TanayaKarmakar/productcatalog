package com.app.medium;

import com.app.common.BinaryTree.TreeNode;

/**
 * @author t0k02w6 on 07/04/23
 * @project ds-algo-2021-leetcode
 */
public class DeepestLeavesSumLeetcode1302 {
  private static int sum = 0;
  private static int maxHeight = 0;

  private static int deepestLeavesSum(TreeNode root) {
    maxHeight = 0;
    sum = 0;
    deepestLeavesSumRec(root, 0);
    return sum;
  }

  private static void deepestLeavesSumRec(TreeNode root, int height) {
    if(root == null)
      return;
    boolean isLeaf = (root.left == null && root.right == null);
    if(isLeaf) {
      if(height == maxHeight) {
        sum += root.val;
      } else {
        if(height > maxHeight) {
          maxHeight = height;
          sum = root.val;
        }
      }
    }
    deepestLeavesSumRec(root.left, height + 1);
    deepestLeavesSumRec(root.right, height + 1);
  }


  public static void main(String[] args) {

  }
}
