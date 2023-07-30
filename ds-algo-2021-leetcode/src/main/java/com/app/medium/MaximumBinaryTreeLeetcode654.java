package com.app.medium;

import com.app.common.BinaryTree.TreeNode;

/**
 * @author t0k02w6 on 06/07/23
 * @project ds-algo-2021-leetcode
 */
public class MaximumBinaryTreeLeetcode654 {
  private static TreeNode constructMaximumBinaryTree(int[] nums) {
    return maxBinaryTreeRec(nums, 0, nums.length - 1);
  }

  private static TreeNode maxBinaryTreeRec(int[] nums, int start, int end) {
    if(start > end)
      return null;
    int maxIndx = findMax(nums, start, end);
    TreeNode root = new TreeNode(nums[maxIndx]);
    root.left = maxBinaryTreeRec(nums, start, maxIndx - 1);
    root.right = maxBinaryTreeRec(nums, maxIndx + 1, end);
    return root;
  }

  private static int findMax(int[] nums, int start, int end) {
    int maxIndx = -1;
    int maxNumber = Integer.MIN_VALUE;
    for(int i = start; i <= end; i++) {
      if(maxNumber < nums[i]) {
        maxNumber = nums[i];
        maxIndx = i;
      }
    }
    return maxIndx;
  }

  public static void main(String[] args) {

  }
}
