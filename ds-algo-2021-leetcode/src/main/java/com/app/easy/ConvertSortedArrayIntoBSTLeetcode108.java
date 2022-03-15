package com.app.easy;

import com.app.common.BinaryTree;
import com.app.common.BinaryTree.TreeNode;

/**
 * @author t0k02w6 on 15/03/22
 * @project ds-algo-2021
 */
public class ConvertSortedArrayIntoBSTLeetcode108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        TreeNode root = sortedArrayToBSTRec(nums, start, end);
        return root;
    }

    private TreeNode sortedArrayToBSTRec(int[] nums, int start, int end) {
        if(start > end)
            return null;
        int mid = (start + end) >> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBSTRec(nums, start, mid - 1);
        root.right = sortedArrayToBSTRec(nums, mid + 1, end);
        return root;
    }

    public static void main(String[] args) {

    }
}
