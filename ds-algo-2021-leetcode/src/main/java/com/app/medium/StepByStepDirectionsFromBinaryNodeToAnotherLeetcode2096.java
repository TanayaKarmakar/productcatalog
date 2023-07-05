package com.app.medium;

import com.app.common.BinaryTree.TreeNode;

/**
 * @author t0k02w6 on 20/06/23
 * @project ds-algo-2021-leetcode
 */
public class StepByStepDirectionsFromBinaryNodeToAnotherLeetcode2096 {
  private static String path;

  private static String getDirections(TreeNode root, int startValue, int destValue) {
    if(root == null)
      return "";
    StringBuilder directions = new StringBuilder();
    StringBuilder finalPath = new StringBuilder();
    TreeNode lca = lca(root, startValue, destValue);
    getDistance(lca, directions, startValue);

    for(int i = 0; i < path.length(); i++) {
      finalPath.append("U");
    }

    directions = new StringBuilder();
    getDistance(lca, directions, destValue);
    finalPath.append(path);
    return finalPath.toString();
  }

  private static void getDistance(TreeNode root, StringBuilder directions, int startValue) {
    if(root == null)
      return;
    if(root.val == startValue) {
      path = directions.toString();
      return;
    }
    getDistance(root.left, directions.append("L"), startValue);
    directions.deleteCharAt(directions.length() - 1);

    getDistance(root.right, directions.append("R"), startValue);
    directions.deleteCharAt(directions.length() - 1);
  }

  private static TreeNode lca(TreeNode root, int value1, int value2) {
    if(root == null)
      return null;
    if(root.val == value1 || root.val == value2)
      return root;
    TreeNode left = lca(root.left, value1, value2);
    TreeNode right = lca(root.right, value1, value2);
    if(left != null && right != null)
      return root;
    else if(left != null)
      return left;
    else
      return right;
  }

  public static void main(String[] args) {

  }
}
