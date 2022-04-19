package tree;

import common.BinaryTree;
import common.BinaryTree.TreeNode;

/**
 * @author t0k02w6 on 18/04/22
 * @project ds-algo-2021
 */
public class BalancedBinaryTree {
    private static boolean isBalanaced(TreeNode root) {
        if(root == null)
            return true;
        if(checkBalance(root) == -1)
            return false;
        return true;
    }

    private static int checkBalance(TreeNode root) {
        if(root == null)
            return 0;
        int lHeight = checkBalance(root.left);
        if(lHeight == -1)
            return -1;
        int rHeight = checkBalance(root.right);
        if(rHeight == -1)
            return -1;
        int diff = Math.abs(lHeight - rHeight);
        if(diff > 1)
            return -1;
        return 1 + Integer.max(lHeight, rHeight);
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = new TreeNode(3);
        bt.root.left = new TreeNode(4);
        bt.root.right = new TreeNode(8);
        bt.root.left.left = new TreeNode(5);
        bt.root.left.right = new TreeNode(6);
        bt.root.right.right = new TreeNode(7);
        bt.root.right.right.left = new TreeNode(6);

        boolean ans = isBalanaced(bt.root);

        System.out.println(ans);
    }
}
