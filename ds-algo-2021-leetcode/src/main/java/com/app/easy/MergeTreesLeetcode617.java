package com.app.easy;

import com.app.common.BinaryTree.TreeNode;

/**
 * @author t0k02w6 on 07/07/23
 * @project ds-algo-2021-leetcode
 */
public class MergeTreesLeetcode617 {
  private static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
    if(root1 == null && root2 == null)
      return null;
    if(root1 == null || root2 == null) {
      if(root1 == null)
        return root2;
      if(root2 == null)
        return root1;
    }
    root1.val = root1.val + root2.val;
    root1.left = mergeTrees(root1.left, root2.left);
    root1.right = mergeTrees(root1.right, root2.right);
    return root1;
  }

  public static void main(String[] args) {

  }
}
