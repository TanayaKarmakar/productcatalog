package tree;

import common.BinaryTree;
import common.BinaryTree.TreeNode;

/**
 * @author t0k02w6 on 19/04/22
 * @project ds-algo-2021
 */
public class DiameterOfTree {
    private static int res = 0;

    private static int diaMeter(TreeNode root) {
        if(root == null)
            return 0;
        int lh = diaMeter(root.left);
        int rh = diaMeter(root.right);
        res = Integer.max(res, 1 + lh + rh);
        return 1 + Integer.max(lh, rh);
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = new TreeNode(10);
        bt.root.left = new TreeNode(20);
        bt.root.right = new TreeNode(30);
        bt.root.right.left = new TreeNode(40);
        bt.root.right.right = new TreeNode(60);
        bt.root.right.left.left = new TreeNode(60);
        bt.root.right.right.right = new TreeNode(70);

        int ans = diaMeter(bt.root);

        System.out.println(ans);
    }
}
