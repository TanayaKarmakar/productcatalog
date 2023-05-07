package com.app.medium;

import com.app.common.BinaryTree.TreeNode;

/**
 * @author t0k02w6 on 06/05/23
 * @project ds-algo-2021-leetcode
 */
public class StepByStepDirectionsInBinaryTreeNodesLeetcode2096 {
  private static String path;

  private static String getDirections(TreeNode root, int startValue, int destValue) {
    if(root == null)
      return "";
    TreeNode ancestor = lca(root, startValue, destValue);
    StringBuilder directions = new StringBuilder();
    StringBuilder finalPath = new StringBuilder();
    getDistance(ancestor, startValue, directions);

    for(int i = 0; i < path.length(); i++) {
      finalPath.append("U");
    }

    directions = new StringBuilder();
    getDistance(ancestor, destValue, directions);
    finalPath.append(path);

    return finalPath.toString();
  }

  private static void getDistance(TreeNode root, int value, StringBuilder directions) {
    if(root == null)
      return;
    if(root.val == value) {
      path = directions.toString();
      return;
    }
    getDistance(root.left, value, directions.append("L"));
    directions.deleteCharAt(directions.length() - 1);

    getDistance(root.right, value, directions.append("R"));
    directions.deleteCharAt(directions.length() - 1);
  }

  private static TreeNode lca(TreeNode root, int startValue, int endValue) {
    if(root == null)
      return null;
    if(root.val == startValue || root.val == endValue)
      return root;
    TreeNode left = lca(root.left, startValue, endValue);
    TreeNode right = lca(root.right, startValue, endValue);
    if(left != null && right != null)
      return root;
    else if(left == null)
      return right;
    else
      return left;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(1);
    root.right = new TreeNode(2);
    root.left.left = new TreeNode(3);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(4);

    String finalPath = getDirections(root, 3, 6);

    System.out.println(finalPath);
  }
}
