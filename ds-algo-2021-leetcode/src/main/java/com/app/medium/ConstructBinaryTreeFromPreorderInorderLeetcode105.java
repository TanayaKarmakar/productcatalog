package com.app.medium;

import com.app.common.BinaryTree.TreeNode;
public class ConstructBinaryTreeFromPreorderInorderLeetcode105 {
    static int preIndx = 0;

    private static TreeNode buildTree(int[] preorder, int[] inorder) {
        preIndx = 0;
        int start = 0;
        int end = preorder.length - 1;
        return buildTreeRec(preorder, inorder, start, end);
    }

    private static TreeNode buildTreeRec(int[] preorder, int[] inorder, int start, int end) {
        if(start > end)
            return null;
        int val = preorder[preIndx++];
        TreeNode root = new TreeNode(val);
        int searhIndx = searchItem(inorder,val, start, end);
        if(searhIndx != -1) {
            root.left = buildTreeRec(preorder, inorder, start, searhIndx - 1);
            root.right = buildTreeRec(preorder,inorder, searhIndx + 1, end);
        }
        return root;
    }

    private static int searchItem(int[] inorder, int val, int start, int end) {
        for(int i = start; i <= end; i++) {
            if(inorder[i] == val)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
