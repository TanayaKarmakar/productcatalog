package tree;

import common.BinaryTree;
import common.BinaryTree.TreeNode;

/**
 * @author t0k02w6 on 19/04/22
 * @project ds-algo-2021
 */
public class ConstructBinaryTreeFromInorderPreorder {
    static int preIndx = 0;

    private static TreeNode construct(int[] in, int[] pre) {
        preIndx = 0;
        return constructRec(in, pre, 0, in.length - 1);
    }

    private static int searchNode(int[] in, int val, int start, int end) {
        for(int i = start; i <= end; i++) {
            if(in[i] == val)
                return i;
        }
        return -1;
    }

    private static TreeNode constructRec(int[] in, int[] pre, int start, int end) {
        if(start > end)
            return null;
        int indx = searchNode(in, pre[preIndx], start, end);
        if(indx == -1)
            return null;
        TreeNode root = new TreeNode(pre[preIndx]);
        preIndx++;
        root.left = constructRec(in, pre, start, indx - 1);
        root.right = constructRec(in, pre, indx + 1, end);
        return root;
    }

    private static void inorder(TreeNode root) {
        if(root == null)
            return;
        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);
    }

    public static void main(String[] args) {
        int[] pre = {10,20,30};
        int[] in = {20,10,30};
        TreeNode root = construct(in, pre);

        inorder(root);
    }
}
