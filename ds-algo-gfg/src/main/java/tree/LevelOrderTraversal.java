package tree;

import common.BinaryTree;
import common.BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author t0k02w6 on 18/04/22
 * @project ds-algo-2021
 */
public class LevelOrderTraversal {
    private static void levelOrderTraversal(BinaryTree.TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            TreeNode remNode = q.poll();
            System.out.print(remNode.val + " ");
            if(remNode.left != null)
                q.add(remNode.left);
            if(remNode.right != null)
                q.add(remNode.right);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = new TreeNode(10);
        bt.root.left = new TreeNode(20);
        bt.root.right = new TreeNode(30);
        bt.root.left.left = new TreeNode(8);
        bt.root.left.right = new TreeNode(7);
        bt.root.right.right = new TreeNode(6);
        bt.root.left.right.left = new TreeNode(9);
        bt.root.left.right.right = new TreeNode(15);

        levelOrderTraversal(bt.root);
    }
}
