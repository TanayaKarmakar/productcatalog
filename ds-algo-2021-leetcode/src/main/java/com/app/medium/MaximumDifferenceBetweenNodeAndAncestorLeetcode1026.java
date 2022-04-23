package com.app.medium;

import com.app.common.BinaryTree;
import com.app.common.BinaryTree.TreeNode;
import com.app.common.Pair;

/**
 * @author t0k02w6 on 22/04/22
 * @project ds-algo-2021
 */
public class MaximumDifferenceBetweenNodeAndAncestorLeetcode1026 {
    private static int maxDiffRec(TreeNode root, int min, int max) {
        if(root == null)
            return max - min;
        max = Integer.max(root.val, max);
        min = Integer.min(root.val, min);
        int left = maxDiffRec(root.left, min, max);
        int right = maxDiffRec(root.right, min, max);
        return Integer.max(left, right);
    }

    private static int maxAncestorDiff(TreeNode root) {
        if(root == null)
            return 0;
        return maxDiffRec(root, root.val, root.val);
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = new TreeNode(8);
        bt.root.left = new TreeNode(3);
        bt.root.right = new TreeNode(10);
        bt.root.left.left = new TreeNode(1);
        bt.root.left.right = new TreeNode(6);
        bt.root.right.right = new TreeNode(14);
        bt.root.left.right.left = new TreeNode(4);
        bt.root.left.right.right = new TreeNode(7);
        bt.root.right.right.left = new TreeNode(13);

        int ans = maxAncestorDiff(bt.root);

        System.out.println(ans);
    }
}
