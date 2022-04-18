package tree;


import common.BinaryTree;
import common.BinaryTree.TreeNode;


/**
 * @author t0k02w6 on 18/04/22
 * @project ds-algo-2021
 */
public class PrintNodeAtKDistance {
    private static void print(TreeNode root, int k) {
        if(root == null)
            return;
        printRec(root, 0, k);
    }

    private static void printRec(TreeNode root, int current, int k) {
        if(root == null)
            return;
        if(current == k)
            System.out.println(root.val);
        printRec(root.left, current + 1, k);
        printRec(root.right, current + 1, k);
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = new TreeNode(10);
        bt.root.left = new TreeNode(20);
        bt.root.right = new TreeNode(30);
        bt.root.left.left = new TreeNode(40);
        bt.root.left.right = new TreeNode(50);
        bt.root.right.right = new TreeNode(70);

        int k = 2;

        print(bt.root, k);
    }
}
