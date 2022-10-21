package com.app.medium;

//import com.app.common.BinaryTree;
import com.app.common.BinaryTree.TreeNode;


/**
 * @author t0k02w6 on 16/10/22
 * @project ds-algo-2021-leetcode
 */
public class PathSumIIILeetcode437 {
  private static int pathSum(TreeNode root, int targetSum) {
    if(root == null)
      return 0;
    return pathSum(root.left, targetSum) + pathSum(root.right, targetSum)
        + pathSum2(root, targetSum);
  }

  private static int pathSum2(TreeNode root, int targetSum) {
    if(root == null)
      return 0;
    int res = 0;
    if(root.val == targetSum)
      res++;
    res += pathSum2(root.left, targetSum - root.val);
    res += pathSum2(root.right, targetSum - root.val);
    return res;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(10);
    root.left = new TreeNode(5);
    root.right = new TreeNode(-3);
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(2);
    root.left.left.left = new TreeNode(3);
    root.left.left.right = new TreeNode(-2);
    root.left.right.right = new TreeNode(1);
    root.right.right = new TreeNode(11);

    int target = 8;
    int ans = pathSum(root, target);

    System.out.println(ans);
  }
}
