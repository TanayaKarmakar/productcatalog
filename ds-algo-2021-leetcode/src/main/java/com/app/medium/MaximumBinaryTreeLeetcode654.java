package com.app.medium;

import com.app.common.BinaryTree;
import com.app.common.BinaryTree.TreeNode;

/**
 * @author t0k02w6 on 03/05/22
 * @project ds-algo-2021
 */
public class MaximumBinaryTreeLeetcode654 {
    private static TreeNode constructMaximumBinaryTree(int[] nums) {
        return contructTreeRec(nums, 0, nums.length - 1);
    }

    private static TreeNode contructTreeRec(int[] nums, int start, int end) {
        if(start > end)
            return null;
        int maxIndx = findMax(nums, start, end);
        TreeNode root = new TreeNode(nums[maxIndx]);
        root.left = contructTreeRec(nums, start, maxIndx - 1);
        root.right = contructTreeRec(nums, maxIndx + 1, end);
        return root;
    }

    private static int findMax(int[] nums, int start, int end) {
        int maxIndx =  start;
        for(int i = start; i <= end; i++) {
            if(nums[maxIndx] < nums[i])
                maxIndx = i;
        }
        return maxIndx;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,6,0,5};
        TreeNode root = constructMaximumBinaryTree(nums);

    }
}
