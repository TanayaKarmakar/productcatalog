package com.app.easy;

import com.app.common.BinaryTree;
import com.app.common.BinaryTree.TreeNode;

/**
 * @author t0k02w6 on 14/03/22
 * @project ds-algo-2021
 */
public class RangeSumBSTLeetcode938 {
    private static int sum = 0;

    private static void rangeSumBSTRec(TreeNode root, int low, int high) {
        if(root == null)
            return;
        if(root.val >= low && root.val <= high) {
            sum += root.val;
            rangeSumBSTRec(root.left, low, high);
            rangeSumBSTRec(root.right, low, high);
        } else if(root.val > high) {
            rangeSumBSTRec(root.left, low, high);
        } else {
            rangeSumBSTRec(root.right, low, high);
        }
    }

    private static int rangeSumBST(TreeNode root, int low, int high) {
        sum = 0;
        rangeSumBSTRec(root, low, high);
        return sum;
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = new TreeNode(10);
        bt.root.left = new TreeNode(5);
        bt.root.right = new TreeNode(15);
        bt.root.left.left = new TreeNode(3);
        bt.root.left.right = new TreeNode(7);
        bt.root.right.right = new TreeNode(18);

        int low = 7;
        int high = 15;

        int ans = rangeSumBST(bt.root, low, high);

        System.out.println(ans);
    }
}
