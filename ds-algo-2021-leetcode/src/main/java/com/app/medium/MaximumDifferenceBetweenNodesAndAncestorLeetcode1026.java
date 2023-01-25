package com.app.medium;

//import com.app.common.BinaryTree;
import com.app.common.BinaryTree.TreeNode;

/**
 * @author t0k02w6 on 06/12/22
 * @project ds-algo-2021
 */
public class MaximumDifferenceBetweenNodesAndAncestorLeetcode1026 {
  private static int result = 0;

  private static int maxAncestorDiff(TreeNode root) {
    result = 0;
    maxDiffRec(root, root.val, root.val);
    return result;
  }

  private static void maxDiffRec(TreeNode root, int cmin, int cmax) {
    if(root == null)
      return;
    result = Integer.max(result, Integer.max(Math.abs(root.val - cmin),
        Math.abs(root.val - cmax)));
    cmax = Integer.max(root.val, cmax);
    cmin = Integer.min(root.val, cmin);
    maxDiffRec(root.left, cmin, cmax);
    maxDiffRec(root.right, cmin, cmax);
  }

  public static void main(String[] args) {

  }
}
