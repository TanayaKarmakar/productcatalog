package com.app.medium;

import com.app.common.BinaryTree.TreeNode;

/**
 * @author t0k02w6 on 10/06/23
 * @project ds-algo-2021-leetcode
 */
public class ValidateBinarySearchTreeLeetcode98 {
  private static boolean isValidBST(TreeNode root) {
    if(root == null)
      return true;
    return isValidBSTRec(root, 2L * Integer.MIN_VALUE, 2L * Integer.MAX_VALUE);
  }

  private static boolean isValidBSTRec(TreeNode root, long minValue, long maxValue) {
    if(root == null)
      return true;
    if(root.val < minValue || root.val > maxValue)
      return false;
    return isValidBSTRec(root.left, minValue, root.val)
        && isValidBSTRec(root.right, root.val, maxValue);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(1);
    root.right = new TreeNode(4);
    root.right.left = new TreeNode(3);
    root.right.right = new TreeNode(6);

    boolean ans = isValidBST(root);

    System.out.println(ans);
  }
}
