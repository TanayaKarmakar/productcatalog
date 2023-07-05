package com.app.medium;

import com.app.common.BinaryTree.TreeNode;


/**
 * @author t0k02w6 on 03/07/23
 * @project ds-algo-2021-leetcode
 */
public class PathSumIIILeetcode437 {


  private static int pathSum(TreeNode root, int targetSum) {
    if(root == null)
      return 0;
    return pathSum(root.left, targetSum) + pathSum(root.right, targetSum)
        + pathSum2(root, targetSum);
  }

  private static int pathSum2(TreeNode root, int sum) {
    if(root == null)
      return 0;
    int res = 0;
    if(root.val == sum)
      res++;
    res += pathSum2(root.left, sum - root.val);
    res += pathSum2(root.right, sum - root.val);
    return res;
  }

  public static void main(String[] args) {

  }
}
