package com.app.medium;

import com.app.common.BinaryTree.TreeNode;
import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 06/05/23
 * @project ds-algo-2021-leetcode
 */
public class PathSumIIILeetcode437 {
  private static int count = 0;
  static Map<Integer, Integer> sumMap = new HashMap<>();

  private static int pathSum(TreeNode root, int targetSum) {
    count = 0;
    sumMap.clear();
    sumMap.put(0, 1);
    pathSumRec(root, targetSum, 0);
    return count;
  }

  private static void pathSumRec(TreeNode root, int targetSum, int previousSum) {
    if(root == null)
      return;
    int currentSum = root.val + previousSum;
    if(sumMap.containsKey(currentSum - targetSum)) {
      count += sumMap.get(currentSum - targetSum);
    }
    sumMap.put(currentSum, sumMap.getOrDefault(currentSum, 0) + 1);
    pathSumRec(root.left, targetSum, currentSum);
    pathSumRec(root.right, targetSum, currentSum);
    int value = sumMap.get(currentSum);
    sumMap.put(currentSum, value - 1);
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

    int targetSum = 8;

    int ans = pathSum(root, targetSum);

    System.out.println(ans);
  }
}
