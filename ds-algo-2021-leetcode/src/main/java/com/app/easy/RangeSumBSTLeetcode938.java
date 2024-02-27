package com.app.easy;

import com.app.common.BinaryTree.TreeNode;

public class RangeSumBSTLeetcode938 {
    private static int sum = 0;

    private static int rangeSumBST(TreeNode root, int low, int high) {
        sum = 0;
        rangeSumBSTRec(root, low, high);
        return sum;
    }

    private static void rangeSumBSTRec(TreeNode root, int low, int high) {
        if(root == null)
            return;
        if(root.val >= low && root.val <= high)
            sum += root.val;
        rangeSumBSTRec(root.left, low, high);
        rangeSumBSTRec(root.right, low, high);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(18);

        int ans = rangeSumBST(root, 7, 15);
        System.out.println(ans);
    }
}
