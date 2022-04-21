package tree;

import common.BinaryTree;
import common.BinaryTree.TreeNode;

/**
 * @author t0k02w6 on 19/04/22
 * @project ds-algo-2021
 */
public class LowestCommonAncestorOfBinaryTree {
    private static TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
        if(root == p || root == q)
            return root;
        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);

        if(left != null && right != null)
            return root;
        else if(left != null)
            return left;
        else
            return right;
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = new TreeNode(10);
        bt.root.left = new TreeNode(20);
        bt.root.right = new TreeNode(30);
        bt.root.right.left = new TreeNode(40);
        bt.root.right.right = new TreeNode(50);

        TreeNode ans = lca(bt.root, bt.root.right.left, bt.root.right.right);

        System.out.println(ans.val);
    }
}
