package com.app.medium;

import com.app.common.BinaryTree;
import com.app.common.BinaryTree.TreeNode;

/**
 * @author t0k02w6 on 20/10/22
 * @project ds-algo-2021-leetcode
 */
public class DeepestLeavesSumLeetcode1302 {
  private static int sum = 0;
  private static int maxDepth = 0;

  private static void sumRec(TreeNode root, int level) {
    if(root == null)
      return;
    boolean isLeaf = (root.left == null && root.right == null);
    if(isLeaf) {
      if(level > maxDepth) {
        maxDepth = level;
        sum = root.val;
      } else if(level == maxDepth) {
        sum += root.val;
      }
    }
    sumRec(root.left, level + 1);
    sumRec(root.right, level + 1);
  }

  private static int deepestLeavesSum(TreeNode root) {
    sum = 0;
    maxDepth = 0;
    sumRec(root, 0);
    return sum;
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
