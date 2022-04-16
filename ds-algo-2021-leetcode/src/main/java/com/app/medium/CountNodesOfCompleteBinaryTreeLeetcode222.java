package com.app.medium;

import com.app.common.BinaryTree;
import com.app.common.BinaryTree.TreeNode;

/**
 * @author t0k02w6 on 13/04/22
 * @project ds-algo-2021
 */
public class CountNodesOfCompleteBinaryTreeLeetcode222 {
    private static int countNodes(TreeNode root) {
        if(root == null)
            return 0;
        int lCount = 0;
        TreeNode left = root;
        while(left != null) {
            lCount++;
            left = left.left;
        }

        int rCount = 0;
        TreeNode right = root;
        while(right != null) {
            rCount++;
            right = right.right;
        }

        if(lCount == rCount)
            return (int)Math.pow(2, lCount) - 1;
        else
            return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = new TreeNode(1);
        bt.root.left = new TreeNode(2);
        bt.root.right = new TreeNode(3);
        bt.root.left.left = new TreeNode(4);
        bt.root.left.right = new TreeNode(5);
        bt.root.right.left = new TreeNode(6);

        int ans = countNodes(bt.root);

        System.out.println(ans);
    }
}
