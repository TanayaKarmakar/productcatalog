package com.app.medium;

import com.app.common.BinaryTree;
import com.app.common.BinaryTree.TreeNode;


/**
 * @author t0k02w6 on 03/05/22
 * @project ds-algo-2021
 */
public class DeleteLeavesWithGivenValueLeetcode1325 {
    private static boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }

    private static TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root == null)
            return null;
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);
        if(root.val == target && isLeaf(root))
            return null;
        return root;
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = new TreeNode(1);
        bt.root.left = new TreeNode(2);
        bt.root.right = new TreeNode(3);
        bt.root.left.left = new TreeNode(2);
        bt.root.right.left = new TreeNode(2);
        bt.root.right.right = new TreeNode(4);

        bt.root = removeLeafNodes(bt.root, 2);


    }
}
