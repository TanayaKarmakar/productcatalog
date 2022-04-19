package tree;

import common.BinaryTree;
import common.BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author t0k02w6 on 18/04/22
 * @project ds-algo-2021
 */
public class LevelOrderTraversalLineByLine {
    private static void levelOrderTraversalLineByLine(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode remNode = q.poll();
                System.out.print(remNode.val + " ");
                if(remNode.left != null)
                    q.add(remNode.left);
                if(remNode.right != null)
                    q.add(remNode.right);
            }
            System.out.println();
        }

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

        levelOrderTraversalLineByLine(bt.root);
    }
}
