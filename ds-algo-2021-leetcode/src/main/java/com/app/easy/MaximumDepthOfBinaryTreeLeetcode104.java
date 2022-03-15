package com.app.easy;

import com.app.common.BinaryTree;
import com.app.common.BinaryTree.TreeNode;

/**
 * @author t0k02w6 on 15/03/22
 * @project ds-algo-2021
 */
public class MaximumDepthOfBinaryTreeLeetcode104 {
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return 1 + Integer.max(left, right);
    }

    public static void main(String[] args) {

    }
}
