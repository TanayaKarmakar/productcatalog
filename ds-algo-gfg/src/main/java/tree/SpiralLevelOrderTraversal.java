package tree;

import common.BinaryTree;
import common.BinaryTree.TreeNode;

import java.util.Stack;

/**
 * @author t0k02w6 on 19/04/22
 * @project ds-algo-2021
 */
public class SpiralLevelOrderTraversal {
    private static void spiralOrder(TreeNode root) {
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        s1.push(root);

        while(!s1.isEmpty() || !s2.isEmpty()) {
            while(!s1.isEmpty()) {
                TreeNode remNode = s1.pop();
                System.out.print(remNode.val + " ");
                if(remNode.left != null)
                    s2.push(remNode.left);
                if(remNode.right != null)
                    s2.push(remNode.right);
            }
            System.out.println();

            while(!s2.isEmpty()) {
                TreeNode remNode = s2.pop();
                System.out.print(remNode.val + " ");
                if(remNode.right != null)
                    s1.push(remNode.right);
                if(remNode.left != null)
                    s1.push(remNode.left);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = new TreeNode(1);
        bt.root.left = new TreeNode(2);
        bt.root.right = new TreeNode(3);
        bt.root.left.left = new TreeNode(4);
        bt.root.left.right = new TreeNode(5);
        bt.root.right.left = new TreeNode(6);
        bt.root.right.right = new TreeNode(7);
        bt.root.left.left.left = new TreeNode(8);
        bt.root.left.left.right = new TreeNode(9);
        bt.root.right.left.left = new TreeNode(10);
        bt.root.right.left.right = new TreeNode(11);

        spiralOrder(bt.root);
    }
}
