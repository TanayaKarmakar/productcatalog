package com.app.medium;

import com.app.common.BinaryTree;
import com.app.common.BinaryTree.TreeNode;

/**
 * @author t0k02w6 on 06/04/23
 * @project ds-algo-2021-leetcode
 */
public class FlipEquivalentBinaryTreeLeetcode951 {
  private static boolean flipEquiv(TreeNode root1, TreeNode root2) {
    if(root1 == null && root2 == null)
      return true;
    if(root1 == null || root2 == null)
      return false;
    boolean option1 = flipEquiv(root1.left, root2.left)
        && flipEquiv(root1.right, root2.right);
    boolean option2 = flipEquiv(root1.left, root2.right)
        && flipEquiv(root1.right, root2.left);
    return root1.val == root2.val && (option1 || option2);
  }

  public static void main(String[] args) {

  }
}
