package com.app.medium;

import com.app.common.BinaryTree.TreeNode;

/**
 * @author t0k02w6 on 08/07/23
 * @project ds-algo-2021-leetcode
 */
public class DeleteLeavesWithAGivenValueLeetcode1325 {
  private static TreeNode removeLeafNodes(TreeNode root, int target) {
    if(root == null)
      return null;
    root.left = removeLeafNodes(root.left, target);
    root.right = removeLeafNodes(root.right, target);
    if(root.val == target && root.left == null && root.right == null)
      return null;
    return root;
  }

  public static void main(String[] args) {

  }
}
