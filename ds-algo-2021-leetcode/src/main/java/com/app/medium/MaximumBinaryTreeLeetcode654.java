package com.app.medium;

import com.app.common.BinaryTree;
import com.app.common.BinaryTree.TreeNode;

/**
 * @author t0k02w6 on 13/04/23
 * @project ds-algo-2021-leetcode
 */
public class MaximumBinaryTreeLeetcode654 {
  private static TreeNode constructMaximumBinaryTree(int[] nums) {
    return constructMaximumBinaryTreeRec(nums, 0, nums.length - 1);
  }

  private static TreeNode constructMaximumBinaryTreeRec(int[] nums, int start, int end) {
    if(start > end)
      return null;
    int maxIndx = -1;
    int maxNum = Integer.MIN_VALUE;
    for(int i = start; i <= end; i++) {
      if(nums[i] > maxNum) {
        maxNum = nums[i];
        maxIndx = i;
      }
    }
    TreeNode root = new TreeNode(nums[maxIndx]);
    root.left = constructMaximumBinaryTreeRec(nums, start, maxIndx - 1);
    root.right = constructMaximumBinaryTreeRec(nums, maxIndx + 1, end);
    return root;
  }

  public static void main(String[] args) {

  }
}
