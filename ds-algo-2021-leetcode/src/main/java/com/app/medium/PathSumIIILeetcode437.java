package com.app.medium;

import com.app.common.BinaryTree.TreeNode;

public class PathSumIIILeetcode437 {
    private static int pathSum(TreeNode root, int targetSum) {
        if(root == null)
            return 0;
        return pathSum(root.left, targetSum)
                + pathSum(root.right, targetSum)
                + pathSum2(root, targetSum);
    }

    private static int pathSum2(TreeNode root, int target) {
        if(root == null)
            return 0;
        int res = 0;
        if(root.val == target)
            res++;
        res += pathSum2(root.left, target - root.val);
        res += pathSum2(root.right, target - root.val);
        return res;
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

        int ans = pathSum(root, 8);
        System.out.println(ans);
    }
}
