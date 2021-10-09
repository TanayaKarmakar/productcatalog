package com.app.common;


/**
 * @author t0k02w6 on 09/10/21
 * @project ds-algo-2021
 */
public class BinaryTree {
    public TreeNode root;

    public BinaryTree() {

    }

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
