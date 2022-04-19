package tree;

import common.BinaryTree;
import common.BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author t0k02w6 on 18/04/22
 * @project ds-algo-2021
 */
public class PrintLeftView {
    private static void printLeftView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if(i == 0)
                    System.out.println(node.val);
                if(node.left != null)
                    q.add(node.left);
                if(node.right != null)
                    q.add(node.right);
            }
        }

    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = new TreeNode(30);
        bt.root.right = new TreeNode(50);
        bt.root.right.left = new TreeNode(60);
        bt.root.right.left.right = new TreeNode(10);

        printLeftView(bt.root);
    }
}
