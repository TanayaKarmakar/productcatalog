package com.app.medium;

import com.app.common.BinaryTree;
import com.app.common.BinaryTree.TreeNode;

import java.util.Stack;

/**
 * @author t0k02w6 on 13/04/22
 * @project ds-algo-2021
 */
public class KthSmallestElementInBSTLeetcode230 {
    private static int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            k--;
            if(k == 0)
                return root.val;
            root = root.right;
        }
        return -1;
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = new TreeNode(3);
        bt.root.left = new TreeNode(1);
        bt.root.right = new TreeNode(4);
        bt.root.left.right = new TreeNode(2);

        int k = 1;

        int ans = kthSmallest(bt.root, k);
        System.out.println(ans);

    }
}
