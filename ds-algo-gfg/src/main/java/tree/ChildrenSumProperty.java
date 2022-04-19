package tree;

import common.BinaryTree;
import common.BinaryTree.TreeNode;

/**
 * @author t0k02w6 on 18/04/22
 * @project ds-algo-2021
 */
public class ChildrenSumProperty {
    private static boolean childrenSum(TreeNode root) {
        if(root == null)
            return true;
        if(root.left == null && root.right == null)
            return true;
        boolean lFlag = childrenSum(root.left);
        boolean rFlag = childrenSum(root.right);
        int sum = 0;

        if(root.left != null)
            sum += root.left.val;
        if(root.right != null)
            sum += root.right.val;
        return (sum == root.val && lFlag && rFlag);
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = new TreeNode(20);
        bt.root.left = new TreeNode(8);
        bt.root.right = new TreeNode(12);
        bt.root.left.left = new TreeNode(3);
        bt.root.left.right = new TreeNode(5);

        boolean ans = childrenSum(bt.root);

        System.out.println(ans);

        bt = new BinaryTree();
        bt.root = new TreeNode(3);
        bt.root.left = new TreeNode(1);
        bt.root.right = new TreeNode(2);
        bt.root.right.left = new TreeNode(1);
        bt.root.right.right = new TreeNode(2);

        ans = childrenSum(bt.root);
        System.out.println(ans);

    }
}
