package tree;

import common.BinaryTree;
import common.BinaryTree.TreeNode;

/**
 * @author t0k02w6 on 18/04/22
 * @project ds-algo-2021
 */
public class MaximumValueInBinaryTree {
    private static int max = Integer.MIN_VALUE;

    private static int maximumValue(TreeNode root) {
        max = Integer.MIN_VALUE;
        maximumRec(root);
        return max;
    }

    private static void maximumRec(TreeNode root) {
        if(root == null)
            return;
        max = Integer.max(root.val, max);
        maximumRec(root.left);
        maximumRec(root.right);
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = new TreeNode(10);
        bt.root.left = new TreeNode(20);
        bt.root.right = new TreeNode(30);
        bt.root.left.left = new TreeNode(40);
        bt.root.left.right = new TreeNode(50);
        bt.root.right.right = new TreeNode(60);
        bt.root.right.right.left = new TreeNode(70);
        bt.root.right.right.right = new TreeNode(80);

        int ans = maximumValue(bt.root);
        System.out.println(ans);
    }
}
