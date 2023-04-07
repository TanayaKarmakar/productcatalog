package com.app.medium;

import com.app.common.BinaryTree.TreeNode;

/**
 * @author t0k02w6 on 16/02/23
 * @project ds-algo-2021-leetcode
 */
public class ValidateBinarySearchTreeLeetcode98 {
  private static boolean isValidBST(TreeNode root) {
    return validate(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  private static boolean validate(TreeNode root, int minValue, int maxValue) {
    if(root == null)
      return true;
    if(root.val > maxValue || root.val < minValue)
      return false;
    return validate(root.left, minValue, root.val)
        && validate(root.right, root.val, maxValue);
  }

  public static void main(String[] args) {

  }
}
