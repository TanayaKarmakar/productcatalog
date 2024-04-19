package com.app.medium;

import com.app.common.BinaryTree.TreeNode;

public class DeleteLeavesWithGivenValueLeetcode1325 {
    private static TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root == null)
            return null;
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);
        if(root.left == null && root.right == null) {
            if(root.val == target)
                return null;
        }
        return root;
    }

    public static void main(String[] args) {

    }
}
