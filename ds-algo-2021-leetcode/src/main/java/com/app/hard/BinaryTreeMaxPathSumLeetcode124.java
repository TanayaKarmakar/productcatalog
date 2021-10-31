package com.app.hard;

import com.app.common.BinaryTree;
import com.app.common.BinaryTree.TreeNode;


/**
 * @author t0k02w6 on 30/10/21
 * @project ds-algo-2021
 */
public class BinaryTreeMaxPathSumLeetcode124 {
    private static int result = Integer.MIN_VALUE;

    private static int maxPathSumRec(TreeNode root) {
        if(root == null)
            return 0;
        int leftVal = maxPathSumRec(root.left);
        int rightVal = maxPathSumRec(root.right);
        int sum = Integer.max(root.val, root.val + Integer.max(leftVal, rightVal));
        result = Integer.max(result, Integer.max(sum, root.val + leftVal + rightVal));
        return sum;
    }

    private static int maxPathSum(TreeNode root) {
        if(root == null)
            return 0;
        maxPathSumRec(root);
        return result;
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = new TreeNode(-10);
        bt.root.left = new TreeNode(9);
        bt.root.right = new TreeNode(20);
        bt.root.right.left = new TreeNode(15);
        bt.root.right.right = new TreeNode(7);

        int ans = maxPathSum(bt.root);
        System.out.println(ans);
    }
}
