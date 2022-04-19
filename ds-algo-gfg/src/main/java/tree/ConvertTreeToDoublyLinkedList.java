package tree;

import common.BinaryTree;
import common.BinaryTree.TreeNode;

/**
 * @author t0k02w6 on 19/04/22
 * @project ds-algo-2021
 */
public class ConvertTreeToDoublyLinkedList {
    static TreeNode prev = null;
    static TreeNode head = null;

    private static TreeNode convertToDLL(TreeNode root) {
        if(root == null)
            return null;
        head = convertToDLL(root.left);
        if(prev == null)
            head = root;
        else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        convertToDLL(root.right);
        return head;
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = new TreeNode(10);
        bt.root.left = new TreeNode(5);
        bt.root.right = new TreeNode(20);
        bt.root.right.left = new TreeNode(30);
        bt.root.right.right = new TreeNode(35);

        head = convertToDLL(bt.root);
        TreeNode tmp = head;
        while(tmp != null) {
            System.out.print(tmp.val + " ");
            tmp = tmp.right;
        }
        System.out.println();
    }
}
