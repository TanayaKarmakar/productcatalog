package com.app.medium;

import com.app.common.BinaryTree.TreeNode;

/**
 * @author t0k02w6 on 03/07/23
 * @project ds-algo-2021-leetcode
 */
public class DeepestLeavesSumLeetcode1302 {
  private static int maxHeight = 0;
  private static int sum = 0;

  private static int deepestLeavesSum(TreeNode root) {
    maxHeight = 0;
    sum = 0;
    deepestLeavesSumRec(root, 0);
    return sum;
  }

  private static void deepestLeavesSumRec(TreeNode root, int level) {
    if(root == null)
      return;
    boolean isLeaf = (root.left == null && root.right == null);
    if(isLeaf) {
      if(maxHeight == level) {
        sum += root.val;
      } else {
        if(maxHeight < level) {
          maxHeight = level;
          sum = root.val;
        }
      }
    }
    deepestLeavesSumRec(root.left, level + 1);
    deepestLeavesSumRec(root.right, level + 1);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right.right = new TreeNode(6);
    root.left.left.left = new TreeNode(7);
    root.right.right.right = new TreeNode(8);

    int ans = deepestLeavesSum(root);

    System.out.println(ans);
  }
}
